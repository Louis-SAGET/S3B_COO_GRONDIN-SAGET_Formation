package exercice_mvc;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class ModelListeMot implements Sujet {

	/**
	 * Liste des observateurs
	 */
	private ArrayList<String> liste;

	public ArrayList<String> getListe() {
		return liste;
	}

	private ArrayList<Observateur> observateurs;

	public ModelListeMot() {
		this.observateurs = new ArrayList<Observateur>();
		liste = new ArrayList<String>();
	}

	@Override
	/**
	 * Ajoute un observateur a la liste
	 */
	public void enregistrerObservateur(Observateur o) {
		this.observateurs.add(o);
	}

	@Override
	/**
	 * Supprime un observateur a la liste
	 */
	public void supprimerObservateur(Observateur o) {
		int i = this.observateurs.indexOf(o);
		if (i >= 0) {
			this.observateurs.remove(i);
		}
	}

	@Override
	/**
	 * Informe tous les observateurs de la liste des modifications des mesures meteo
	 * en appelant leurs methodes actualiser
	 */
	public void notifierObservateurs() {
		for (int i = 0; i < this.observateurs.size(); i++) {
			Observateur observer = this.observateurs.get(i);
			observer.actualiser(this);
		}
	}

	/**
	 * modifie la valeur de compteur en fonction du parametre
	 * 
	 * @param valeur entiere a ajouter au compteur
	 */
	public void modifier(String mot) {
		if (!mot.equals("")) 
			this.liste.add(mot);
			this.notifierObservateurs(); // Appel de actualiser sur toutes les vues

	}

}
