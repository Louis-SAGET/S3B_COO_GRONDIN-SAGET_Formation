/*
 * @autor Grondin Florent, Saget Louis
 */
package ClasseTP;

/**
 * La Class Identite.
 */
public class Identite {

	/** Le prenom. */
	private String nip, nom, prenom;

	/**
	 * Creer un nouvel objet identite.
	 *
	 * @param ip l'ip
	 * @param n  le nom
	 * @param p  le prenom
	 */
	public Identite(String ip, String n, String p) {
		this.nip = ip;
		this.nom = n;
		this.prenom = p;
	}

	@Override
	public String toString() {
		return "Nom: "+nom+"\nPrenom: "+prenom+"\nNumero d'identification: "+nip;
	}

	/**
	 * Recupere l'element nip.
	 *
	 * @return l'element nip
	 */
	public String getNip() {
		return nip;
	}

	/**
	 * Recupere l'element nom.
	 *
	 * @return l'element nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Recupere l'element prenom.
	 *
	 * @return l'element prenom
	 */
	public String getPrenom() {
		return prenom;
	}

}
