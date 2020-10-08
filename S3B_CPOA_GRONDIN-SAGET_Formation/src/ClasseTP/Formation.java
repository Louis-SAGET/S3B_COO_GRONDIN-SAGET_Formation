package ClasseTP;

import java.util.*;

public class Formation {

	private String identifiant;

	private Map<String, Integer> matieres;
	
	public Formation(String id, Map<String, Integer> mat ) {
		this.identifiant = new String(id);
		this.matieres = new HashMap<String, Integer>();
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public Map<String, Integer> getMatiere() {
		return matieres;
	}
	
	public void ajouterMatiere(String mat, int coef) {
		if (!this.matieres.containsKey(mat)) {
			this.matieres.put(mat,coef);
		}
	}
	
	public void supprimerMatiere(String mat) {
		if (this.matieres.containsKey(mat)) {
			this.matieres.remove(mat);
		}
	}
	
	public int connaitreCoefficient(String mat) {
		int coef;
		if (this.matieres.containsKey(mat)) {
			coef = this.matieres.get(mat);
		} else {
			coef = 0;
		}
		return coef;
	}

}
