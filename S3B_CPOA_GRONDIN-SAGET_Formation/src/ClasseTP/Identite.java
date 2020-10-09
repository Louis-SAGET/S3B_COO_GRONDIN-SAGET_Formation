/*
 * @autor Grondin Florent, Saget Louis
 */
package ClasseTP;

/**
 * La Class Identite.
 */
public class Identite {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nip == null) ? 0 : nip.hashCode());
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
		Identite other = (Identite) obj;
		if (nip == null) {
			if (other.nip != null)
				return false;
		} else if (!nip.equals(other.nip))
			return false;
		return true;
	}

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
		return "Nom: " + nom + "\nPrenom: " + prenom + "\nNumero d'identification: " + nip;
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
