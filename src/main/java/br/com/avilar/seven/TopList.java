package br.com.avilar.seven;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
		
					int[] arr1 = {2, 5, 7, 4, 1};
					ArrayList<Integer> arrList = new ArrayList<>();
					for(int i=0; i<arr1.length; i++) {
						arrList.add(arr1[i]);
					}
					
					//List<List<String>> geral = FiltrarOsAtributos.filtraOsAtributosList(corpo, arrList);
					//List<List<String>> geral2 = FiltrarOsAtributos.filtraOsAtributosList(corpo2, arrList);
					
					
	    		   List<Tipo> detalhesTipoFilme = PassarDetalhesCadaTipo.passarDetalhesCada
	    				   (FiltrarOsAtributos.
	    						   filtraOsAtributosList(corpo, arrList), TipoDeConteudo.Filmes);
	    		   List<Tipo> detalhesTipoSerie = PassarDetalhesCadaTipo.passarDetalhesCada
	    				   (FiltrarOsAtributos.
	    						   filtraOsAtributosList(corpo2, arrList), TipoDeConteudo.TVShow);
	    		      		   
	    		   
	    		   
	    		   List<? extends Content> mixedList = Stream.of(detalhesTipoFilme, detalhesTipoSerie)
	    				   .flatMap(Collection::stream)
	    				   .collect(Collectors.toList());
	    		   
	    		   Collections.sort(detalhesTipoFilme);
	    		   Collections.sort(detalhesTipoSerie, Comparator.reverseOrder());
	    		   Collections.sort((List<Tipo>) mixedList, Comparator.comparing(Content::getNota).reversed());
	    		   
	    		   HTMLGenerator.htmlTipos(detalhesTipoFilme , detalhesTipoSerie, (List<Tipo>) mixedList);
	    		   //HTMLGenerator.htmlTipos(detalhesTipo3, detalhesTipo4);
	    		   	}
	
	@SuppressWarnings("unused")
	private static List<String> parseListaInteira(String[] moviesArray) {
		
		return Stream.of(moviesArray).collect(Collectors.toList());
			
	}

	}

	





