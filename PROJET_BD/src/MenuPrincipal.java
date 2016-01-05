
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame implements ActionListener {
	private JButton affIn;
	
	public MenuPrincipal(){
	
	JPanel button = new JPanel();
	
	 
	  affIn=new JButton("Acceder aux opérations");

	 
	 button.add(affIn);

	 button.setLayout(new GridLayout(1,2));
	 
	 affIn.addActionListener(this);

	 this.setTitle("Projet BDA S3 MARTELOT ERIC, CISSE STEEVE, ROUSSART LUDOVIC, TOURNOUX THOMAS");
	    this.setContentPane(button);
	    this.setSize(800, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);  
    }

@Override
public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	if (source==affIn)
	{
		Menu m=new Menu();
	}
}
}
