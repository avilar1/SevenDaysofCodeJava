package br.com.avilar.seven;

public abstract class Tipo {
	public String titulo;
	public String urlImagem;
	public String nota;
	public String ano;
	public String ranking;
	
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
}
