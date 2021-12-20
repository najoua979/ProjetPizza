package projetPizza;

import java.util.ArrayList;

public class Commande {
	private static int nbCommand = 0;
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	
	public Commande() {
		id = nbCommand;
		nbCommand++;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	private ArrayList<Pizza> listPizza;
	private int prixTotal;
	
	
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public ArrayList<Pizza> getListPizza() {
		return listPizza;
	}
	public void setListPizza(ArrayList<Pizza> listPizza) {
		this.listPizza = listPizza;
	}
	public int getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal() {
		int prix=0;
		for(Pizza pizza:listPizza) {
			prix = prix + pizza.getPrix();

		}
		prixTotal = prix;	
	}
	
	
	

}
