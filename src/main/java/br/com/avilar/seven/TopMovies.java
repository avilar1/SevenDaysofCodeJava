package br.com.avilar.seven;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopMovies {

	public static void main(String[] args) throws URISyntaxException, Exception {
		
		String key = args[0];	
		if (key == null)
		      throw new IllegalArgumentException("Coloque a key no argumento!");
		
		String url = "https://imdb-api.com/en/API/Top250Movies/<apiKey>";
	      URI uri = new URI(url.replace("<apiKey>", key));
	      HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

	      HttpClient client = HttpClient.newHttpClient();
	      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	      
	      String respostaDaRequisicao = response.body();
	      
	      //System.out.println(respostaDaRequisicao);
	
	//dia 2
	      
	      String json = respostaDaRequisicao;
	      
	      String[] corpo = parseToCorpo(json);
	      
	    		   List<String> listaInteira = parseListaInteira(corpo);
	    		   //imprime todas as listas
	    		   //listaInteira.forEach(System.out::println);
	    		   
	    		   List<String> titulos = filtraOsAtributosPelaLocalizacao(corpo, 3);
	    		   List<String> urlImages = filtraOsAtributosPelaLocalizacao(corpo, 5);
	    		   
	    		   //imprime todos titulos
//	    		   for (String nomeTitulos : titulos) {
//	    			   System.out.println(nomeTitulos);
//				}
	    		   
	    		   for(int i=0; i< titulos.size(); i++) {
	    			  System.out.println(titulos.get(i) + "url da imagem: " + urlImages.get(i));
	    		   }	    		   
	    		}

	
	private static List<String> filtraOsAtributosPelaLocalizacao(String[] corpo, int i) {
		
		return Stream.of(corpo).map(key -> key.split("\",\"")[i])
		        .map(val -> val.split(":\"")[1])
		        .map(element -> element.replaceAll("\"", ""))
		        .collect(Collectors.toList());	
	}

	private static String[] parseToCorpo(String json) {
		
		Pattern pattern = Pattern.compile("(.*\\[(.*)].*)");
	    Matcher matcher = pattern.matcher(json);
	    
	    if (!matcher.matches())
		      throw new IllegalStateException("Pattern " + pattern.pattern() +" has no match in JSON");

	    
		    String[] corpoDoJson = matcher.group(2).split("},\\{");
		    corpoDoJson[0] = corpoDoJson[0].substring(1);
		    int last = corpoDoJson.length - 1;
		    String lastString = corpoDoJson[last];
		    corpoDoJson[last] = lastString.substring(0, lastString.length() - 1);
		    return corpoDoJson;
	}

	private static List<String> parseListaInteira(String[] moviesArray) {
		
		return Stream.of(moviesArray).toList();
	
		
	}


	
	
}

