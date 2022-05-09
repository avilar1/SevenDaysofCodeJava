package br.com.avilar.seven;

import java.util.ArrayList;
import java.util.List;




public abstract class PassarDetalhesCadaTipo{


public static List<Tipo> passarDetalhesCada(List<List<String>> geral, TipoDeConteudo tipo) {
	
	List<Tipo> listaTipo = new ArrayList<>();
	
	if(tipo == TipoDeConteudo.Filmes) {
		for(int i=0; i<geral.get(0).size(); i++) {
			listaTipo.add(
		          new Filmes(geral.get(0).get(i), geral.get(1).get(i), geral.get(2).get(i), geral.get(3).get(i), geral.get(4).get(i)));
	
		}
	}
	
	if(tipo == TipoDeConteudo.TVShow) {
		for(int i=0; i<geral.get(0).size(); i++) {
			listaTipo.add(
		          new TVShow(geral.get(0).get(i), geral.get(1).get(i), geral.get(2).get(i), geral.get(3).get(i), geral.get(4).get(i)));
	
		}
	}
		
	return listaTipo;
}

}




