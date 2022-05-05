package br.com.avilar.seven;

public class Filmes {

	public String titulo;
	public String urlImagem;
	public String nota;
	public String ano;
	
	
	public Filmes(String titulo, String urlImagem) {

		this.titulo = titulo;
		this.urlImagem = urlImagem;
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
	


	
}
