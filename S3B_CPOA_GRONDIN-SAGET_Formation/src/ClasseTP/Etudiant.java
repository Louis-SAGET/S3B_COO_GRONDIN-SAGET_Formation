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

	/** Le id. */
	private Identite id;

	/** La formation. */
	private Formation formation;

	/** Les notes. */
	private Map<String, ArrayList<Double>> notes;

	/**
	 * Creer un nouvel objet etudiant.
	 *
	 * @param i le i
	 * @param f le f
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

	public void ajouterNote(String mat, double note) {
		if ((int) formation.connaitreCoefficient(mat) != -1) {
			if (note >= 0 && note <= 20) {
				if (this.notes.containsKey(mat)) {
					ArrayList<Double> templNote = this.notes.get(mat);
					templNote.add(note);
					this.notes.replace(mat, this.notes.get(mat), templNote);
				} else {
					ArrayList<Double> lNote = new ArrayList<Double>();
					lNote.add(note);
					this.notes.put(mat, lNote);
				}
			} else
				System.out.println("La note n'est pas dans le bon format: 0 <= Note <= 20 ");

		} else
			System.out.println("L'etudiant n'etudie pas la matière: " + mat + " dans sa formation");
	}

	public double calculerMoyenneMatiere(String mat) {
		double somme = 0.0;
		ArrayList<Double> listeNote = (ArrayList<Double>) this.notes.get(mat);
		if ((int) formation.connaitreCoefficient(mat) != -1) {
			for (Double ln : listeNote) {
				somme += ln;
			}
		}

		return Math.round((somme / listeNote.size())*100.0)/100.0;
	}

	public double calculerMoyenneGenerale() {
		double somme = 0.0;
		int nbNote = 0;
		Double sommeNoteMatiere = 0.0;
		ArrayList<Double> listeNote;
		Set<String> ensembleCle = notes.keySet();
		for (String mat : ensembleCle) {
			sommeNoteMatiere=calculerMoyenneMatiere(mat);
			sommeNoteMatiere *=formation.connaitreCoefficient(mat);
			nbNote += formation.connaitreCoefficient(mat);
			somme += sommeNoteMatiere;
			sommeNoteMatiere = 0.0;

		}
		return Math.round((somme / nbNote)*100.0)/100.0;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer("\n*********************Relevé de notes*********************\n\n");
		res.append(id + "\nFormation: " + formation + "\n\n|~~Resultats~~|\n");
		Set<String> ensembleCle = notes.keySet();
		ArrayList<Double> listeNote;
		for (String mat : ensembleCle) {
			listeNote = (ArrayList<Double>) this.notes.get(mat);
			res.append("----" + mat + " (coefficient " + formation.connaitreCoefficient(mat) + "):----\n\t");
			for (Double ln : listeNote) {
				res.append(ln + ", ");
			}
			res.append("\n\t\t      Moyenne dans la matière: " + mat + " = " + calculerMoyenneMatiere(mat)+"\n");

		}
		res.append("\n\n\t\t\t\t\tMoyenne Générale: " + calculerMoyenneGenerale());
		res.append("\n\n**********************************************************\n");
		return res.toString();

	}
}
