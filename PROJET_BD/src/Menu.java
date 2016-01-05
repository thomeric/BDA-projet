

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame  implements ActionListener {
	
	private JPanel container;
	private JPanel top;
	
	
	private JButton Q1;
	private JButton Q2;
	private JButton Q3;
	private JButton Q4;
	private JButton Q5;
	private JButton Q6;
	private JButton Q7;
	private JButton Q8;
	
	private JButton retour;
	
	public Menu()
	{
		
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		
		top = new JPanel();
		top.setLayout(new GridLayout(9,1));
	
		

	    
	    container.add(top, BorderLayout.NORTH);
	  	 
	  //  container.setBackground(Color.YELLOW);
	    
	   
		
		Q1 = new JButton("Afficher le nombre d'étudiants avec stage cette année");
		Q2 = new JButton("Afficher le nombre d'étudiants sans stage cette année");
		Q3 = new JButton("Afficher le nombre d'étudiants sans stage à une certaine date pour une année précédente choisie par l'utilisateur");
		Q4 = new JButton("Afficher le nombre de stagiaires pris par chaque entreprise durant les n dernières années");
		Q5 = new JButton("Afficher le nombre moyen de stagiaires encadrés par les entreprises dans les n dernières années");
		Q6 = new JButton("Afficher le nombre de stages par zone géographiques (département, ville)");
		Q7 = new JButton("Afficher le nombre de stages pour toutes les zones géographiques (département, ville)");
		Q8 = new JButton("Afficher toutes les entreprises et leur contact ayant eu au moins un stage dans les n dernières années");
		retour = new JButton("Retour");
		
		
		top.add(Q1);
		top.add(Q2);
		top.add(Q3);
		top.add(Q4);
		top.add(Q5);
		top.add(Q6);
		top.add(Q7);
		top.add(Q8);
		top.add(retour);
		
		Q1.addActionListener(this);
		Q2.addActionListener(this);
		Q3.addActionListener(this);
		Q4.addActionListener(this);
		Q5.addActionListener(this);
		Q6.addActionListener(this);
		Q7.addActionListener(this);
		Q8.addActionListener(this);
		retour.addActionListener(this);
		
		this.setTitle("Accueil");
	    this.setContentPane(container);
	    this.setSize(800, 270);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);  
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
	
		if (source==Q1)
		{					
		   //repondre Q1
			
			
		}
		if(source==Q2){
			//repondre Q2
		}
		if(source==Q3){
		
			//repondre Q3
		
		}
		if(source==Q4){
			//repondre Q4
		
		}
		if(source==Q5){
			//repondre Q5
		}
		if(source==Q6){
			//repondre Q6
		}
		if(source==Q7){
			//repondre Q7
		}
		if(source==Q8){
			//repondre Q8
		}
		if(source==retour){
			dispose();
		}
	}


}
	
	

