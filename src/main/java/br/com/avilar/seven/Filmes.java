package br.com.avilar.seven;




public class Filmes extends Tipo implements Content {
	
	
	
	public Filmes(String titulo, String urlImagem, String nota, String ano, String ranking) {
		super(titulo, urlImagem, nota, ano, ranking);
		
	}

	@Override
	public int compareTo(Tipo o) {
		return this.getTitulo().compareTo(o.getTitulo());
	}

	@Override
	public String tipo() {
		
		return "Filme";
	}
	
	
}



