package br.com.avilar.seven;

public class TVShow extends Tipo implements Content{

	
	public TVShow(String titulo, String urlImagem, String nota, String ano, String ranking) {
		super(titulo, urlImagem, nota, ano, ranking);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int compareTo(Tipo o) {
		return this.getAno().compareTo(o.getAno());
	}

	@Override
	public String tipo() {
		
		return "Serie";
	}
}
