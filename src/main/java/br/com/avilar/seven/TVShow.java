package br.com.avilar.seven;

public class TVShow extends Tipo implements Content{

	
	public TVShow(String titulo, String urlImagem, String nota, String ano, String ranking) {
		super(titulo, urlImagem, nota, ano, ranking);
		// TODO Auto-generated constructor stub
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
}
