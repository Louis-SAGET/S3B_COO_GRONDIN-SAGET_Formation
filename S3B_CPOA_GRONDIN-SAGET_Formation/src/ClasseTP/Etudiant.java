/*
 * @autor Grondin Florent, Saget Louis
 */
package ClasseTP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * La Class Etudiant.
 */

public class Etudiant {

	/** L'id. */
	private Identite id;

	/** La formation. */
	private Formation formation;

	/** Les notes. */
	private Map<String, ArrayList<Double>> notes;

	/**
	 * Creer un nouvel objet etudiant.
	 *
	 * @param i l' id
	 * @param f la formation
	 */
	public Etudiant(Identite i, Formation f) {
		this.formation = f;
		this.id = i;
		this.notes = new HashMap<String, ArrayList<Double>>();
	}

	/**
	 * Recupere l'element id.
	 *
	 * @return l'element id
	 */
	public Identite getId() {
		return id;
	}

	/**
	 * Recupere l'element formation.
	 *
	 * @return l'element formation
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * Recupere l'element notes.
	 *
	 * @return l'element notes
	 */
	public Map<String, ArrayList<Double>> getNotes() {
		return notes;
	}

	/**
	 * methode : Ajouter note.
	 *
	 * @param mat  le mat
	 * @param note le note
	 */
	public void ajouterNote(String mat, double note) {
		// test si la formation contient la matiere passée en parametre
		if ((int) formation.connaitreCoefficient(mat) != -1) {
			// test si la note est comprise entre 0 et 20
			if (note >= 0 && note <= 20) {
				// test si l'etudiant à deja une note dans la matiere en parametre
				if (this.notes.containsKey(mat)) {
					// si la matiere contient deja une note alors on rajoute une note a la liste de
					// note
					ArrayList<Double> templNote = this.notes.get(mat);
					templNote.add(note);
					this.notes.replace(mat, this.notes.get(mat), templNote);
				} else {
					// si la matiere ne contient pas de note alors on rajoute la matiere avec une
					// nouvelle liste de notes contenant 1 element
					ArrayList<Double> lNote = new ArrayList<Double>();
					lNote.add(note);
					this.notes.put(mat, lNote);
				}
			} else
				System.out.println("La note n'est pas dans le bon format: 0 <= Note <= 20 ");

		} else
			System.out.println("L'etudiant n'etudie pas la matière: " + mat + " dans sa formation");
	}

	/**
	 * Calculer moyenne matiere.
	 *
	 * @param mat la matiere
	 * @return la valeur de la moyenne
	 */
	public double calculerMoyenneMatiere(String mat) {
		double somme = 0.0;

		ArrayList<Double> listeNote = null;
		// test si la matiere est dans la formation
		if ((int) formation.connaitreCoefficient(mat) != -1) {
			// on recupere la liste de note de la matiere
			listeNote = (ArrayList<Double>) this.notes.get(mat);
			//parcours liste de notes
			for (Double ln : listeNote) {
				somme += ln;
			}
		}

		return Math.round((somme / listeNote.size()) * 100.0) / 100.0;
	}

	/**
	 * Calculer moyenne generale.
	 *
	 * @return la valeur de la moyenne generale
	 */
	public double calculerMoyenneGenerale() {
		double somme = 0.0;
		int nbNote = 0;
		Double sommeNoteMatiere = 0.0;
		ArrayList<Double> listeNote;
		//on recupere l'ensemble des matieres
		Set<String> ensembleCle = notes.keySet();
		//on parcours l'ensemble des matieres
		for (String mat : ensembleCle) {
			//on calcul les moyennes de chaque matieres
			sommeNoteMatiere = calculerMoyenneMatiere(mat);
			//on multiplie par le coeff de la matiere
			sommeNoteMatiere *= formation.connaitreCoefficient(mat);
			//on recupere le nombre de notes grace au coeff
			nbNote += formation.connaitreCoefficient(mat);
			//on ajoute a la somme total la valeur de la moyenne de la matiere multiplié par son coeff
			somme += sommeNoteMatiere;
			//on remet la somme des notes de la matiere à 0
			sommeNoteMatiere = 0.0;

		}
		return Math.round((somme / nbNote) * 100.0) / 100.0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Methode affichant l'objet Etudiant
	 *
	 * @return la valeur string
	 */
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer("\n************************Relevé de notes*************************\n\n");
		res.append(id + "\nFormation: " + formation + "\n\n|~~Resultats~~|\n");
		Set<String> ensembleCle = notes.keySet();
		ArrayList<Double> listeNote;
		for (String mat : ensembleCle) {
			listeNote = (ArrayList<Double>) this.notes.get(mat);
			res.append("----" + mat + " (coefficient " + formation.connaitreCoefficient(mat) + "):----\n\t");
			for (Double ln : listeNote) {
				res.append(ln + ", ");
			}
			res.append("\n\t\t      Moyenne dans la matière: " + mat + " = " + calculerMoyenneMatiere(mat) + "\n");

		}
		res.append("\n\n\t\t\t\t\tMoyenne Générale: " + calculerMoyenneGenerale());
		res.append("\n\n****************************************************************\n");
		return res.toString();

	}
}
