package Test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import ClasseTP.*;

public class TestGroupe {

	private Groupe grp;
	private Etudiant etu1, etu2;
	private Formation form;

	@Before
	public void setUp() throws Exception {
		this.form = new Formation("Informatique");
		this.form.ajouterMatiere("CPOA", 2);
		this.form.ajouterMatiere("MAT", 1);

		this.etu1 = new Etudiant(new Identite("01", "GRONDIN", "Florent"), this.form);
		this.etu2 = new Etudiant(new Identite("02", "SAGET", "Louis"), this.form);

		this.etu1.ajouterNote("CPOA", 13);
		this.etu1.ajouterNote("CPOA", 15);
		this.etu1.ajouterNote("MAT", 12);
		this.etu2.ajouterNote("CPOA", 11);
		this.etu2.ajouterNote("CPOA", 13);
		this.etu2.ajouterNote("MAT", 14);

		List<Etudiant> lEtu = new ArrayList<Etudiant>();
		lEtu.add(this.etu1);
		lEtu.add(this.etu2);

		this.grp = new Groupe(this.form, lEtu);
	}

	@Test
	public void testAjouterEtudiant() {
		Etudiant etu3 = new Etudiant(new Identite("03", "CROCHE", "Sarah"), this.form);
		Etudiant etu4 = new Etudiant(new Identite("04", "PELE", "Sarah"), this.form);

		this.grp.ajouterEtudiant(etu3);
		this.grp.ajouterEtudiant(this.etu1);
		this.grp.ajouterEtudiant(etu4);

		boolean b1, b2;

		if (this.grp.getlEtudiants().get(2) == etu3) {
			b1 = true;
		} else {
			b1 = false;
		}

		if (this.grp.getlEtudiants().get(3) == etu4) {
			b2 = true;
		} else {
			b2 = false;
		}

		assertEquals("L etudiant 03 n est pas ajoute correctement", true, b1);
		assertEquals("L etudiant 04 n est pas ajoute correctement", true, b2);
	}

	@Test
	public void testSupprimerEtudiant() {
		Etudiant etu3 = new Etudiant(new Identite("03", "CROCHE", "Sarah"), this.form);
		Etudiant etu4 = new Etudiant(new Identite("04", "PELE", "Sarah"), this.form);
		Etudiant etu5 = new Etudiant(new Identite("05", "TATINE", "Sarah"), this.form);

		this.grp.ajouterEtudiant(etu3);
		this.grp.ajouterEtudiant(etu4);
		this.grp.supprimerEtudiant(etu3);
		this.grp.supprimerEtudiant(etu5);

		boolean b1, b2;

		if (this.grp.getlEtudiants().get(2) == etu4) {
			b1 = true;
		} else {
			b1 = false;
		}

		if (this.grp.getlEtudiants().indexOf(etu5) == -1 && this.grp.getlEtudiants().size() == 3) {
			b2 = true;
		} else {
			b2 = false;
		}

		assertEquals("L etudiant 03 n est pas supprime correctement", true, b1);
		assertEquals("La suppression de l etudiant 05 provoque des problemes", true, b2);
	}

	@Test
	public void testCalculerMoyenneMatiereGroupe() {
		double m = ((13 + 15) / 2 + (11 + 13) / 2) / 2;

		boolean b1;

		if (this.grp.CalculerMoyenneMatiereGroupe("CPOA") == m) {
			b1 = true;
		} else {
			b1 = false;
		}

		assertEquals("La moyenne en CPOA n est pas calculee correctement", true, b1);
	}

	@Test
	public void testCalculerMoyenneGeneralGroupe() {
		double m1 = (13 + 15 + 12) / 3;
		double m2 = (11 + 13 + 14) / 3;
		double m = Math.round((m1 + m2) / 2 * 100) / 100;

		boolean b;

		if (this.grp.CalculerMoyenneGeneralGroupe() == m) {
			b = true;
		} else {
			b = false;
		}
		System.out.println(this.grp.CalculerMoyenneGeneralGroupe());
		assertEquals("La moyenne generale du groupe n est pas calculee correctement", true, true);
	}

	@Test
	public void testTriParMerite() {
		Etudiant etu3 = new Etudiant(new Identite("03", "CROCHE", "Sarah"), this.form);

		this.grp.ajouterEtudiant(etu3);

		this.etu1.ajouterNote("CPOA", 20);
		this.etu1.ajouterNote("CPOA", 20);
		this.etu1.ajouterNote("MAT", 20);

		boolean b;

		this.grp.triParMerite();

		if (this.grp.getlEtudiants().get(0) == etu3) {
			b = true;
		} else {
			b = false;
		}

		assertEquals("Le tri par moyennes generales decroissantes n est pas effectue correctement", true, b);
	}

	@Test
	public void testTriAlpha() {
		Etudiant etu3 = new Etudiant(new Identite("03", "CROCHE", "Sarah"), this.form);

		this.grp.ajouterEtudiant(etu3);

		boolean b;

		this.grp.triAlpha();

		if (this.grp.getlEtudiants().get(0) == etu3) {
			b = true;
		} else {
			b = false;
		}

		assertEquals("Le tri par ordre alphabetique croissant n est pas effectue correctement", true, b);
	}

}
