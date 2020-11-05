package exercice_mvc;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class VueListeMot extends JTextArea implements Observateur {

	public VueListeMot(int nbrows, int nbcolonne) {
		super(nbrows, nbcolonne);
	}

	@Override
	public void actualiser(Sujet s) {
		ModelListeMot m = (ModelListeMot) s;
		ArrayList<String> listeMot = m.getListe();
		String res="";
		for (String mot : listeMot) {
				res+=mot + "\n";		
		}
		this.setText(res);

	}

}
