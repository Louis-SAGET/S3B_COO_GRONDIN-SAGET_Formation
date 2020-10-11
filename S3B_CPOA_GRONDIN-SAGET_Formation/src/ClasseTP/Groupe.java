package ClasseTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	}

	public double CalculerMoyenneMatiereGroupe(String mat) {
		double somme = 0.0;
		double moy;

		// test si la matiere est dans la formation
		if ((int) formationGroupe.connaitreCoefficient(mat) != -1) {
			
			//parcours liste d'etudiants
			for (Etudiant e : lEtudiants) {
				if (e.calculerMoyenneMatiere(mat)!=-1) 
					somme += e.calculerMoyenneMatiere(mat);
			}
			moy = Math.round((somme / lEtudiants.size()) * 100.0) / 100.0;
		} else {
			moy = -1;
		}

		return moy;

	}

	public double CalculerMoyenneGeneralGroupe() {
		double somme = 0.0;
		int nbNote = 0;
		Double sommeNoteMatiere = 0.0;
		Map<String, Integer> matiere = formationGroupe.getMatiere();
		Set<String> ma= matiere.keySet();
		
		for (String mat : ma) {
			//on calcul les moyennes de chaque matieres
			sommeNoteMatiere = CalculerMoyenneMatiereGroupe(mat);
			//on multiplie par le coeff de la matiere
			sommeNoteMatiere *= formationGroupe.connaitreCoefficient(mat);
			//on recupere le nombre de notes grace au coeff
			nbNote += formationGroupe.connaitreCoefficient(mat);
			//on ajoute a la somme total la valeur de la moyenne de la matiere multiplié par son coeff
			somme += sommeNoteMatiere;
			//on remet la somme des notes de la matiere à 0
			sommeNoteMatiere = 0.0;

		}
		return Math.round((somme / nbNote) * 100.0) / 100.0;

	}

	public Formation getFormationGroupe() {
		return formationGroupe;
	}

	public List<Etudiant> getlEtudiants() {
		return lEtudiants;
	}
	
	public void triParMerite() {
		int i=0;
		for (Etudiant etudiant : lEtudiants) {
			Etudiant etuSelectionne=etudiant;
			int indice=i;
			for (int j =i+1; j<lEtudiants.size();j++) {
				Etudiant etuTemp = lEtudiants.get(j);
				if (etuSelectionne.calculerMoyenneGenerale()<=etuTemp.calculerMoyenneGenerale()) {
					indice=j;
					etuSelectionne=etuTemp;
				}
			}
			lEtudiants.set(indice, lEtudiants.get(i));
			lEtudiants.set(i, etuSelectionne);
			i++;
		}
	}
	
	public void triAlpha() {
		int i=0;
		for (Etudiant etudiant : lEtudiants) {
			Etudiant etuSelectionne=etudiant;
			int indice=i;
			for (int j =i+1; j<lEtudiants.size();j++) {
				Etudiant etuTemp = lEtudiants.get(j);
				if (etuSelectionne.getId().getNom().compareTo(etuTemp.getId().getNom()) >=1 ) {
					indice=j;
					etuSelectionne=etuTemp;
				}else if (etuSelectionne.getId().getNom().compareTo(etuTemp.getId().getNom()) ==0) {
					if (etuSelectionne.getId().getPrenom().compareTo(etuTemp.getId().getPrenom()) >=1) {
						indice=j;
						etuSelectionne=etuTemp;
					}
				}
			}
			lEtudiants.set(indice, lEtudiants.get(i));
			lEtudiants.set(i, etuSelectionne);
			i++;
		}
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
		Identite oups = new Identite("9876", "Salu", "Oah");
		Identite oups2 = new Identite("01235", "Louis", "Saget");
		Identite i1= new Identite("9484", "Grondin", "FLUTE");
		Identite i2= new Identite("9482", "Jacke", "florent");
		Identite i3= new Identite("9444", "Grondin", "florent");

		Etudiant fl = new Etudiant(flo, scientifique);
		//Etudiant lu = new Etudiant(luca, litteraire);
		Etudiant ok = new Etudiant(flo, scientifique);
		Etudiant pk = new Etudiant(oups, scientifique);
		Etudiant test = new Etudiant(oups2, scientifique);
		Etudiant e1=new Etudiant(i1, scientifique);
		Etudiant e2=new Etudiant(i2, scientifique);
		Etudiant e3=new Etudiant(i3, scientifique);
		Etudiant e4=new Etudiant(luca, scientifique);
		ArrayList<Etudiant> l1 = new ArrayList<Etudiant>();
		l1.add(pk);
		
		//fl.ajouterNote("Francais", 20.00);
		//fl.ajouterNote("Maths", 109);
		fl.ajouterNote("Maths", 0);
		fl.ajouterNote("Maths", 20);
		fl.ajouterNote("Sport", 17);
		fl.ajouterNote("Sport", 14);
		fl.ajouterNote("Sport", 13);
		fl.ajouterNote("Anglais", 3);
		fl.ajouterNote("Anglais", 9);
		fl.ajouterNote("Physique", 4);
		fl.ajouterNote("Physique", 20);
		fl.ajouterNote("Physique", 16);
		
		pk.ajouterNote("Maths", 0);
		pk.ajouterNote("Maths", 20);
		pk.ajouterNote("Sport", 17);
		pk.ajouterNote("Sport", 14);
		pk.ajouterNote("Sport", 13);
		pk.ajouterNote("Anglais", 13);
		pk.ajouterNote("Anglais", 19);
		pk.ajouterNote("Physique", 4);
		pk.ajouterNote("Physique", 0);
		pk.ajouterNote("Physique", 16);
		
		test.ajouterNote("Maths", 0);
		test.ajouterNote("Maths", 20);
		test.ajouterNote("Sport", 7);
		test.ajouterNote("Sport", 14);
		test.ajouterNote("Sport", 13);
		test.ajouterNote("Anglais", 13);
		test.ajouterNote("Anglais", 19);
		test.ajouterNote("Physique", 4);
		test.ajouterNote("Physique", 20);
		test.ajouterNote("Physique", 16);
		
		
		
		//lu.ajouterNote("Francais", 20.00);

		Groupe g1 = new Groupe(scientifique, null);

		g1.ajouterEtudiant(fl);
		g1.ajouterEtudiant(e3);
		g1.ajouterEtudiant(pk);
		g1.ajouterEtudiant(test);
		g1.ajouterEtudiant(e4);
		g1.ajouterEtudiant(e2);
		g1.ajouterEtudiant(e1);
		
		g1.triAlpha();
		System.out.println(g1);
	}

	@Override
	public String toString() {
		return "+-+Formation du groupe d'étudiants: "+this.formationGroupe.getIdentifiant() +"+-+\n\n" + this.lEtudiants;
	}

}
