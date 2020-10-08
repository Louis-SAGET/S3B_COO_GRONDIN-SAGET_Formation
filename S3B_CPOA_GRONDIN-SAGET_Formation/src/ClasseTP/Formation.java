/*
 * @autor Grondin Florent, Saget Louis
 */
package ClasseTP;

import java.util.*;

/**
 * La Class Formation.
 */
public class Formation {

	/** L' identifiant. */
	private String identifiant;

	/** Les matieres. */
	private Map<String, Integer> matieres;

	/**
	 * Creer un nouvel objet formation.
	 *
	 * @param id  le id
	 * @param mat le mat
	 */
	public Formation(String id) {
		this.identifiant = new String(id);
		this.matieres = new HashMap<String, Integer>();
	}

	/**
	 * Recupere l'element identifiant.
	 *
	 * @return l'element identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * Recupere l'element matiere.
	 *
	 * @return l'element matiere
	 */
	public Map<String, Integer> getMatiere() {
		return matieres;
	}

	/**
	 * methode : Ajouter matiere.
	 *
	 * @param mat  la matiere
	 * @param coef le coef
	 */
	public void ajouterMatiere(String mat, int coef) {
		if (!this.matieres.containsKey(mat)) {
			this.matieres.put(mat, coef);
		}
	}

	/**
	 * methode : Supprimer matiere.
	 *
	 * @param mat le mat
	 */
	public void supprimerMatiere(String mat) {
		if (this.matieres.containsKey(mat)) {
			this.matieres.remove(mat);
		}
	}

	@Override
	public String toString() {
		return identifiant+"\nMatieres:"+matieres.keySet();
	}

	/**
	 * Connaitre coefficient.
	 *
	 * @param mat la matiere
	 * @return la valeur du coeff et -1 si la matiere n'existe pas
	 */
	public int connaitreCoefficient(String mat) {
		int coef;
		if (this.matieres.containsKey(mat)) {
			coef = this.matieres.get(mat);
		} else {
			coef = -1;
		}
		return coef;
	}

}
