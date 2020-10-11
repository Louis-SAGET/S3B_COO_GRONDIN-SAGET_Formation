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
		this.etu2.ajouterNote("CPOA", 12);
		this.etu2.ajouterNote("MAT", 14);
		
		List<Etudiant> lEtu = new ArrayList<Etudiant>();
		lEtu.add(this.etu1);
		lEtu.add(this.etu2);
		
		this.grp = new Groupe(this.form, lEtu);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
