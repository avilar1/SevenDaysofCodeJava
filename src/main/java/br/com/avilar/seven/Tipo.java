package br.com.avilar.seven;



public abstract class Tipo implements Content, Comparable<Tipo>{
	private String titulo;
	private String urlImagem;
	private String nota;
	private String ano;
	private String ranking;
	
	public Tipo(String titulo, String urlImagem, String nota, String ano, String ranking) {

		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.nota = nota;
		this.ano = ano;
		this.ranking = ranking;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public String getNota() {
		return nota;
	}
	
	public String getAno() {
		return ano;
	}
	
	public String getRanking() {
		return ranking;
	}
	
	public int compareTo(Content outro) {
	    return this.getNota().compareTo(outro.getNota());
	}
}
