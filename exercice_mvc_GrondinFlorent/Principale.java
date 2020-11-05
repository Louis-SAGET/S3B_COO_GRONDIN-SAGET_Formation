package exercice_mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principale {

	public static void main(String[] args) {
		
		// Composants textuels de l'interface
		VueGrandMot max; 
		VuePetitMot min;
		ModelListeMot liste;
		VueCompterMot vueCompter;
		Controler saisie;

		// JPanel Nord

		liste = new ModelListeMot(); //modele

		saisie = new Controler(liste, 10); //controleur
		saisie.setPreferredSize(new Dimension(200, 30));
		//jpanel nord
		JPanel panneauDeControle = new JPanel(new GridLayout(1, 2));
		panneauDeControle.add(new JLabel("Donner une chaîne " + "    ", JLabel.CENTER));
		panneauDeControle.add(saisie);
		
		//vue center
		VueListeMot vueListe=new VueListeMot(5, 5);

		// JPanel Sud
		JPanel sud =new JPanel(new BorderLayout());
		JPanel panMaxMin = new JPanel(new GridLayout(3, 2));
		panMaxMin.add(new JLabel("Plus grand mot ", JLabel.CENTER));
		max = new VueGrandMot(10); //vue du grand mot
		max.setPreferredSize(new Dimension(200, 30));
		panMaxMin.add(max);

		panMaxMin.add(new JLabel("Plus petit mot ", JLabel.CENTER));
		min = new VuePetitMot(10);//vue du petit mot
		panMaxMin.add(min);
		
		panMaxMin.add(new JLabel("Donner un mot ", JLabel.CENTER));
		vueCompter = new VueCompterMot(10);//vue du petit mot
		panMaxMin.add(vueCompter);
		//compterMot.add(compter);
		saisie.addKeyListener(saisie); //on ajoute le listener
		JButton compter=new JButton("Compter");
		compter.addActionListener(new ControleurBouton(liste));
		sud.add(panMaxMin,BorderLayout.NORTH);
		//sud.add(compterMot,BorderLayout.CENTER);
		sud.add(compter,BorderLayout.SOUTH);
	
		
		//on ajoute les observeurs
		liste.enregistrerObservateur(vueListe);
		liste.enregistrerObservateur(vueCompter);
		liste.enregistrerObservateur(max); 
		liste.enregistrerObservateur(min);
		
		
		// Construction de l'IG dans une JFrame
		JFrame frame = new JFrame();
		frame.getContentPane().add(panneauDeControle, BorderLayout.NORTH);
		frame.getContentPane().add(new JScrollPane(vueListe), BorderLayout.CENTER);
		frame.getContentPane().add(sud, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 500));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
