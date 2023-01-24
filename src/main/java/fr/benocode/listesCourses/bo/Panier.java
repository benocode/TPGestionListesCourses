package fr.benocode.listesCourses.bo;

public class Panier {
	
	private int idPanier;
	private String nomPanier;
	
	/**
	 * Constructeur qui crée un panier de courses
	 * @param idPanier
	 * @param nomPanier
	 */
	public Panier(int idPanier, String nomPanier) {
		this.idPanier = idPanier;
		this.nomPanier = nomPanier;
	}

	/* Getters et setters */
	public String getNomPanier() {
		return nomPanier;
	}

	public void setNomPanier(String nomPanier) {
		this.nomPanier = nomPanier;
	}

	public int getIdPanier() {
		return idPanier;
	}
	
	@Override
	public String toString() {
		return String.format("Panier n°%d [nom=%s]%n", this.idPanier, this.nomPanier);
	}	
}
