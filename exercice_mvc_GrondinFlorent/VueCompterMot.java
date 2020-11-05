package exercice_mvc;

import java.util.ArrayList;

import javax.swing.JTextField;

public class VueCompterMot extends JTextField implements Observateur {

	private boolean supprimer;

	public VueCompterMot(int nbColonne) {
		super(nbColonne);
		supprimer = false;
	}

	@Override
	public void actualiser(Sujet s) {
		if (supprimer) {
			this.setText("");
		}
		ModelListeMot m = (ModelListeMot) s;
		ArrayList<String> listeMot = m.getListe();
		int nbMot = 0;
		for (String mot : listeMot) {
			if (mot.equals(this.getText()))
				nbMot++;

		}
		if (!this.getText().equals("")) {
			this.setText("nb de " + this.getText() + "= " + nbMot);
			supprimer = true;
		} else
			supprimer = false;

	}

}
