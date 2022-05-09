package br.com.avilar.seven;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopList{

	public static void main(String[] args) throws URISyntaxException, Exception {
		
		String key = args[0];
		String urlApi = "https://imdb-api.com/en/API/Top250Movies/<apiKey>";
		String urlApi2 = "https://imdb-api.com/en/API/Top250TVs/<apiKey>";
		
		String[] corpo = Parsear.parseToCorpo(APIClient.ApiCliente(key, urlApi));
		String[] corpo2 = Parsear.parseToCorpo(APIClient.ApiCliente(key, urlApi2));
	      
	    		   //List<String> listaInteira = parseListaInteira(corpo);
	    		   
	    		   //System.out.println(listaInteira.get(0));
	    		   
	    		   List<String> titulos = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo, 2);
	    		   List<String> urlImages = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo, 5);
	    		   List<String> notas = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo, 7);
	    		   List<String> ano = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo, 4);
	    		   List<String> ranking = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo, 1);
	    		   
	    		   List<String> titulos2 = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo2, 2);
	    		   List<String> urlImages2 = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo2, 5);
	    		   List<String> notas2 = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo2, 7);
	    		   List<String> ano2 = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo2, 4);
	    		   List<String> ranking2 = FiltrarOsAtributos.filtraOsAtributosPelaLocalizacao(corpo2, 1);
	    		   
	    		   List<Tipo> detalhesTipo = PassarDetalhesCadaTipo.passarDetalhesCadaTipo(titulos, urlImages, notas, ano, ranking);
	    		   List<Tipo> detalhesTipo2 = PassarDetalhesCadaTipo.passarDetalhesCadaTipo(titulos2, urlImages2, notas2, ano2, ranking2);
	    		   
	    		      		   
	    		   //ImprimeLista.imprimeLista(titulos, detalhesFilmes);
	    		   
	    		   HTMLGenerator.htmlTipos(titulos, detalhesTipo, detalhesTipo2);
	    		   	}
	
	@SuppressWarnings("unused")
	private static List<String> parseListaInteira(String[] moviesArray) {
		
		return Stream.of(moviesArray).collect(Collectors.toList());
	
		
	}

	
}

