package fr.benocode.listesCourses.bo;

public class Panier {
	
	private int idPanier;
	private String nomPanier;
	
	/* Constructeurs */
	public Panier(int idPanier, String nomPanier) {
		this.idPanier = idPanier;
		this.nomPanier = nomPanier;
	}

	public Panier(String nomPanier) {
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
	
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	
	@Override
	public String toString() {
		return String.format("Panier n°%d [nom=%s]%n", this.idPanier, this.nomPanier);
	}
}
