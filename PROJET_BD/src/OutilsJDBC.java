import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutilsJDBC {
	public static Connection openConnection (String url) {
		Connection co=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co= DriverManager.getConnection(url);
		}
		catch (ClassNotFoundException e){
			System.out.println("il manque le driver oracle");
			System.exit(1);
		}
		catch (SQLException e) {
			System.out.println("impossible de se connecter à l'url : "+url);
			System.exit(1);
		}
		return co;
		}
	public static ResultSet exec1Requete (String requete, Connection co, int type){
		ResultSet res=null;
		try {
			Statement st;
			if (type==0){
				st=co.createStatement();}
			else {
				st=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					       	ResultSet.CONCUR_READ_ONLY);
				};
			res= st.executeQuery(requete);
		}
		catch (SQLException e){
			System.out.println("Problème lors de l'exécution de la requete : "+requete);
		};
		return res;
	}

	public static void closeConnection(Connection co){
		try {
			co.close();
			System.out.println("Connexion fermée!");
		}
		catch (SQLException e) {
			System.out.println("Impossible de fermer la connexion");
		}	
}
	
	public static void question1(Connection co) throws SQLException {

		CallableStatement cst = co.prepareCall("?=call nbEtudiantAvecStage()");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println("Il y a  "+ cst.getInt(1)+ " étudiant avec stage");
		
	}
	
	public static void question2(Connection co) throws SQLException {
		CallableStatement cst = co.prepareCall("?=call nbEtudiantSansStage()");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println("Il y a  "+ cst.getInt(1)+ " étudiant sans stage cette année");	
		
	}
	
	public static void question3(Connection co) throws SQLException {
		int n = saisie.entier();
		CallableStatement cst = co.prepareCall("?=call nbEtudiantSansStage(?)");
		cst.setInt(2,n);
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println("Il y a  "+ cst.getInt(1)+ " étudiant sans stage cette année");	
		
	}
	
	public static void question4(Connection co) throws SQLException {
		int n = saisie.entier();
		int annee =2016-n;
		PreparedStatement psm = co
				.prepareStatement("SELECT nomEntreprise, COUNT (ET.numEtudiant) FROM ENTREPRISE E, STAGE S, Etudiant ET WHERE S.entreprise = E.numEntreprise AND S.numstage = ET.stage AND YEAR(ET.dateStage)>=? GROUP BY nomEntreprise;");
		psm.setInt(1, annee);
		ResultSet rs = psm.executeQuery();
		System.out.println("Depuis "+ n + " années, il y a eu :");
		while (rs.next()) {
			// 					NomEntreprise			 nbEtudiant
			System.out.println(rs.getString(1) + " : " + rs.getInt(2)+" étudiant");
		}
		
	}
	
	public static void question5(Connection co) throws SQLException {
		int n = saisie.entier();
		CallableStatement cst = co.prepareCall("?=call MoyEtudiantEntreprise(?)");
		cst.setInt(2,n);
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println("Il y a en moyenne "+ cst.getInt(1)+ " étudiant par entreprise sur une durée de "+ n + " années");	
		
	}
	
	public static void question6(Connection co) throws SQLException {
		String departement = saisie.chaine();
		CallableStatement cst = co.prepareCall("?=call zoneStagePourDepartement(?)");
		cst.setString(2,departement);
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println("Il y a "+ cst.getInt(1)+ " étudiant dans le departement "+ departement);	
		
	}
	
	public static void question7(Connection co) throws SQLException {

		PreparedStatement psm = co
				.prepareStatement("SELECT  E.adresse.departement , COUNT (S.numstage) FROM STAGE S , ENTREPRISE E WHERE E.numEntreprise = S.entreprise GROUP BY E.departement;");
		ResultSet rs = psm.executeQuery();
		while (rs.next()) {
			// 					Departement			 nbStage
			System.out.println(rs.getString(1) + " : " + rs.getInt(2)+" étudiant");
		}
		
	}

	public static void main(String[] args) throws SQLException{
		
		//MenuPrincipal m = new MenuPrincipal();
		String url = "jdbc:oracle:thin:lroussa/A943567812@r2d2.etu.iut-orsay.fr:1521:etudom";
		Connection co = OutilsJDBC.openConnection(url);
		System.out.println("connexion ouverte");// traitement et requete
		question3(co);
		closeConnection(co);
		
	};
	
}