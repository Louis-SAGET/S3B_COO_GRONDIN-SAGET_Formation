package ClasseTP;

/**
 * @author Grondin Florent, Saget Louis
 *
 */
public class Principale {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Formation scientifique=new Formation("science");
		Formation litteraire=new Formation("literaire");
		
		scientifique.ajouterMatiere("Maths", 9);
		scientifique.ajouterMatiere("SVT", 7);
		scientifique.ajouterMatiere("Pysique", 7);
		scientifique.ajouterMatiere("Sport", 2);
		scientifique.ajouterMatiere("Anglais", 3);
		
		litteraire.ajouterMatiere("Francais", 9);
		litteraire.ajouterMatiere("Philosophie", 6);
		litteraire.ajouterMatiere("Litterature", 5);
		litteraire.ajouterMatiere("Anglais", 4);
		litteraire.ajouterMatiere("Sport", 2);
		
		Identite flo=new Identite("01234", "Grondin", "Florent");
		Identite luca=new Identite("43210", "Ametrano", "Luca");
		
		Etudiant fl=new Etudiant(flo, scientifique);
		Etudiant lu=new Etudiant(luca, litteraire);
		
		fl.ajouterNote("Francais", 20.00);
		fl.ajouterNote("Maths", 109);
		fl.ajouterNote("Maths", 0);
		fl.ajouterNote("Maths", 20);
		fl.ajouterNote("Sport", 17);
		fl.ajouterNote("Sport", 14);
		fl.ajouterNote("Sport", 13);
		fl.ajouterNote("Anglais", 13);
		fl.ajouterNote("Anglais", 19);
		fl.ajouterNote("Pysique", 4);
		fl.ajouterNote("Pysique", 20);
		fl.ajouterNote("Pysique", 16);
		
		
		
		lu.ajouterNote("Francais", 20.00);
		System.out.println(lu);
		System.out.println(fl);
		
		

	}

}
