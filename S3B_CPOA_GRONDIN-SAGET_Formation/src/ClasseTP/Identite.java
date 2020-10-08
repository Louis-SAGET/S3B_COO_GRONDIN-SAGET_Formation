package ClasseTP;

public class Identite {
	
	private String nip,nom,prenom;

	public Identite(String ip,String n,String p) {
		this.nip=ip;
		this.nom=n;
		this.prenom=p;
	}

	public String getNip() {
		return nip;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

}
