package exercice_mvc;

import java.util.ArrayList;

import javax.swing.JTextField;

public class VueGrandMot extends JTextField implements Observateur {

	public VueGrandMot(int nbColonne) {
		super(nbColonne);
	}

	@Override
	public void actualiser(Sujet s) {
		ModelListeMot m = (ModelListeMot) s;
		ArrayList<String> listeMot = m.getListe();
		String plusGrand = listeMot.get(0);
		for (String mot : listeMot) {
			if (mot.length() > plusGrand.length()) {
				plusGrand = mot;
			} else if (mot.length()==plusGrand.length()) {
				if (mot.compareTo(plusGrand)>=1) {
					plusGrand = mot;
				}
				
			}
		}
		this.setText("" + plusGrand);

	}

}
