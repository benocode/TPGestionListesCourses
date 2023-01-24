package fr.benocode.listesCourses.bo;

public class Article {

	private int idArticle;
	private String nomArticle;
	private Panier panier;
	
	/**
	 * Crée un article
	 * @param idArticle
	 * @param nomArticle
	 * @param listeCourse
	 */
	public Article(int idArticle, String nomArticle, Panier panier) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.panier = panier;
	}
	
	/**
	 * Constructeur qui crée un article
	 * @param nomArticle
	 * @param listeCourse
	 */
	public Article(String nomArticle, Panier panier) {
		this.nomArticle = nomArticle;
		this.panier = panier;
	}

	/* Getters et setters */
	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public Panier getPanier() {
		return panier;
	}
	
	@Override
	public String toString() {
		return String.format("Article n°%d [nom=%s] dans le panier [%s]%n", this.idArticle, this.nomArticle, this.panier.getNomPanier());
	}
}
