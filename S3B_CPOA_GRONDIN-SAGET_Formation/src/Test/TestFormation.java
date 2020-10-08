
package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ClasseTP.Formation;

/**
 * @author Grondin Florent, Saget Louis
 *
 */
public class TestFormation {
	
	private Formation scientifique;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void initialisation() throws Exception {
		scientifique=new Formation("science");
		scientifique.ajouterMatiere("Maths", 9);
		scientifique.ajouterMatiere("SVT", 7);
		scientifique.ajouterMatiere("Physique", 7);
		scientifique.ajouterMatiere("Sport", 2);
		scientifique.ajouterMatiere("Anglais", 3);
		
	}

	@Test
	public void testConnaitreCoefficient() {
		assertEquals("Le coefficient doit etre egale à 7",7, scientifique.connaitreCoefficient("SVT") );
		//test sur une matiere qui n'existe pas
		assertEquals("Le coefficient doit etre egale à -1",-1, scientifique.connaitreCoefficient("Francais") );
	}
	
	@Test
	public void testSupprimerMatiere() {
		scientifique.supprimerMatiere("SVT");
		assertEquals("Le coefficient doit etre egale à -1",-1, scientifique.connaitreCoefficient("SVT") );
		//test sur une matiere qui n'existe pas
		scientifique.supprimerMatiere("Allemand");
		assertEquals("Le coefficient doit etre egale à -1",-1, scientifique.connaitreCoefficient("Allemand") );
	}

}
