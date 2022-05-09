package br.com.avilar.seven;

import java.util.ArrayList;
import java.util.List;

public abstract class PassarDetalhesCadaTipo implements JsonParser{
public static List<Tipo> passarDetalhesCadaTipo(List<String> titulos, List<String> urlImages, List<String> notas, List<String> ano, List<String> ranking ) {
		
		List<Tipo> listaTipo = new ArrayList<>();

		for(int i=0; i<titulos.size(); i++) {
			listaTipo.add(
			          new Filmes(titulos.get(i), urlImages.get(i), notas.get(i), ano.get(i), ranking.get(i)));
		}
		
		return listaTipo;
	
	}
}
