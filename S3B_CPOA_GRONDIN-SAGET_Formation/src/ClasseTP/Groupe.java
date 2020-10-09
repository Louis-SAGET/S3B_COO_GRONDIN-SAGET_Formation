package ClasseTP;

import java.util.ArrayList;
import java.util.List;

public class Groupe {

	private Formation formationGroupe;
	private List<Etudiant> lEtudiants;

	public Groupe(Formation f, List<Etudiant> lE) {
		if (lE == null)
			this.lEtudiants = new ArrayList<Etudiant>();
		else
			this.lEtudiants = lE;

		this.formationGroupe = f;

	}

	public void ajouterEtudiant(Etudiant e) {
		if (e.getFormation().getIdentifiant().equals(this.formationGroupe.getIdentifiant())) {
			if (lEtudiants.indexOf(e) == -1) {
				lEtudiants.add(e);
			}
		}

	}

	public void supprimerEtudiant(Etudiant e) {
		if (lEtudiants.indexOf(e) != -1) {
			lEtudiants.remove(e);

		}
		System.out.println(lEtudiants);

	}

	public void CalculerMoyenneMatiereGroupe(String mat) {
		// TODO Auto-generated method stub

	}

	public void CalculerMoyenneGeneralGroupe() {
		// TODO Auto-generated method stub

	}

	public Formation getFormationGroupe() {
		return formationGroupe;
	}

	public List<Etudiant> getlEtudiants() {
		return lEtudiants;
	}

	public static void main(String[] args) {
		Formation scientifique = new Formation("science");
		Formation litteraire = new Formation("literaire");

		scientifique.ajouterMatiere("Maths", 9);
		scientifique.ajouterMatiere("SVT", 7);
		scientifique.ajouterMatiere("Physique", 7);
		scientifique.ajouterMatiere("Sport", 2);
		scientifique.ajouterMatiere("Anglais", 3);

		litteraire.ajouterMatiere("Francais", 9);
		litteraire.ajouterMatiere("Philosophie", 6);
		litteraire.ajouterMatiere("Litterature", 5);
		litteraire.ajouterMatiere("Anglais", 4);
		litteraire.ajouterMatiere("Sport", 2);

		Identite flo = new Identite("01234", "Grondin", "Florent");
		Identite luca = new Identite("43210", "Ametrano", "Luca");
		Identite oups = new Identite("9876", "sALu", "oah");
		Identite oups2 = new Identite("01235", "Grondin", "Florent");

		Etudiant fl = new Etudiant(flo, scientifique);
		Etudiant lu = new Etudiant(luca, litteraire);
		Etudiant ok = new Etudiant(flo, scientifique);
		Etudiant pk = new Etudiant(oups, scientifique);
		Etudiant test = new Etudiant(oups2, scientifique);
		ArrayList<Etudiant> l1 = new ArrayList<Etudiant>();
		l1.add(pk);

		Groupe g1 = new Groupe(scientifique, null);
		Groupe g2 = new Groupe(litteraire, l1);

		g1.ajouterEtudiant(fl);
		g1.ajouterEtudiant(lu);
		g1.ajouterEtudiant(test);
		g1.ajouterEtudiant(pk);
		g1.supprimerEtudiant(fl);
	}

}
