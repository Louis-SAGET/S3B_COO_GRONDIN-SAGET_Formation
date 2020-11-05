package exercice_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControleurBouton implements ActionListener {
	/**
	 * Le modele est attribut du controleur
	 */
	private ModelListeMot model;

	/**
	 * Constructeur
	 * 
	 * @param m l'objet Model
	 */
	public ControleurBouton(ModelListeMot m) {
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Compter")) {
			model.modifier("");
		}
	}

}
