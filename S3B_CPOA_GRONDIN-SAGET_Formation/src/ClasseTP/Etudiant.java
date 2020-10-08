/*
 * @autor Grondin Florent, Saget Louis
 */
package ClasseTP;

import java.util.List;
import java.util.Map;

/**
 * La Class Etudiant.
 */
public class Etudiant {

	/** Le id. */
	private Identite id;

	/** La formation. */
	private Formation formation;

	/** Le notes. */
	private Map<String, List<Double>> notes;

	/**
	 * Creer un nouvel objet etudiant.
	 *
	 * @param i le i
	 * @param f le f
	 */
	public Etudiant(Identite i, Formation f) {
		this.formation = f;
		this.id = i;
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
	public Map<String, List<Double>> getNotes() {
		return notes;
	}

}
