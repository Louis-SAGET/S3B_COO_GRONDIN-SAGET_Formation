
package exercice_mvc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * Controleur du MVC - 
 * Apres un clic sur un des boutons 
 * le controleur demande au modele de
 * se modifier
 */
public class Controler extends JTextField implements KeyListener  {
	/**
	 * Le modele est attribut du controleur
	 */
	private ModelListeMot model;
	
	/**
	 * Constructeur
	 * 
	 * @param m l'objet Model 
	 */
	public Controler(ModelListeMot m,int nbcolonnes) {
		super(nbcolonnes);
		this.model=m;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar()=='\n') {
			model.modifier(this.getText());
			this.setText("");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
