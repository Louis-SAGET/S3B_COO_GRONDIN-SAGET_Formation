package exercice_mvc;

import java.util.ArrayList;

import javax.swing.JTextField;

public class VuePetitMot extends JTextField implements Observateur {

	public VuePetitMot(int nbColonne) {
		super(nbColonne);
	}

	@Override
	public void actualiser(Sujet s) {
		ModelListeMot m = (ModelListeMot) s;
		ArrayList<String> listeMot = m.getListe();
		String pluspetit = listeMot.get(0);
		for (String mot : listeMot) {
			if (mot.length() < pluspetit.length()) {
				pluspetit = mot;
			} else if (mot.length()==pluspetit.length()) {
				if (mot.compareTo(pluspetit)<=-1) {
					pluspetit = mot;
				}
				
			}
		}
		this.setText("" + pluspetit);

	}

}
