
package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClasseTP.*;

/**
 * @author Grondin Florent,Saget Louis
 *
 */
public class TestEtudiant {

	private Etudiant etu;
	private Formation form;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.form = new Formation("Informatique");
		this.form.ajouterMatiere("CPOA", 2);
		this.form.ajouterMatiere("MAT", 1);
		
		this.etu = new Etudiant(new Identite("01", "SAGET", "Louis"), this.form);
	}

	@Test
	public void testAjouterNote() {
		this.etu.ajouterNote("CPOA", 12);
		this.etu.ajouterNote("CPOA", 14);
		this.etu.ajouterNote("MAT", 13);
		
		double n1 = this.etu.getNotes().get("CPOA").get(1);
		double n2 = this.etu.getNotes().get("MAT").get(0);
		
		boolean b1, b2;
		
		if (n1 == 14) {
			b1 = true;
		} else {
			b1 = false;
		}
		
		if (n2 == 13) {
			b2 = true;
		} else {
			b2 = false;
		}
		
		assertEquals("La note n a pas ete ajoutee correctement",true, b1);
		assertEquals("La note n a pas ete ajoutee correctement",true, b2);	
	}
	
	@Test
	public void testCalculerMoyenneMatiere() {		
		this.etu.ajouterNote("CPOA", 12);
		this.etu.ajouterNote("CPOA", 14);
		this.etu.ajouterNote("MAT", 13);
		
		double m1 = this.etu.calculerMoyenneMatiere("CPOA");
		double m2 = this.etu.calculerMoyenneMatiere("MAT");	
		double m3 = this.etu.calculerMoyenneMatiere("BDD");
		
		
		boolean b1, b2, b3;
		
		if (m1 == 13) {
			b1 = true;
		} else {
			b1 = false;
		}
		
		if (m2 == 13) {
			b2 = true;
		} else {
			b2 = false;
		}
		
		if (m3 == -1) {
			b3 = true;
		} else {
			b3 = false;
		}
		
		assertEquals("La moyenne de la matiere CPOA est incorrecte",true, b1);
		assertEquals("La moyenne de la matiere MAT est incorrecte",true, b2);
		assertEquals("La moyenne de la matiere BDD est incorrecte",true, b3);
	}
	
	@Test
	public void testCalculerMoyenneGenerale() {
		this.etu.ajouterNote("CPOA", 12);
		this.etu.ajouterNote("CPOA", 14);
		this.etu.ajouterNote("MAT", 13);
		
		double m1 = this.etu.calculerMoyenneGenerale();
		double m2 = (13 * 2 + 13 * 1) / 3;
		
		boolean b;
		
		if (m1 == m2) {
			b = true;
		} else {
			b=  false;
		}
		
		assertEquals("La moyenne generale est incorrecte",true, b);
	}

}
