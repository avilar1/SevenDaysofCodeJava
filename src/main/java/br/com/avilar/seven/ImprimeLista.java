package br.com.avilar.seven;

import java.util.List;

public class ImprimeLista {
	public static void imprimeLista(List<String> titulos, List<Filmes> detalhesFilmes){
		
		for (int i = 0; i < titulos.size(); i++) {
	    	System.out.print(detalhesFilmes.get(i).getTitulo());
	    	System.out.println(detalhesFilmes.get(i).getUrlImagem());
	    }
		
	}
}
