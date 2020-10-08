package ClasseTP;

import java.util.List;
import java.util.Map;

public class Etudiant {
	
	private Identite id;
	private Formation formation;
	private Map<String,List<Double>> notes;

	public Etudiant(Identite i, Formation f) {
		this.formation=f;
		this.id=i;
	}

	public Identite getId() {
		return id;
	}

	public Formation getFormation() {
		return formation;
	}

	public Map<String, List<Double>> getNotes() {
		return notes;
	}

}
