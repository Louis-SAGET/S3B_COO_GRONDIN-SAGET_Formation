
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
		fail("Not yet implemented");
	}

}
