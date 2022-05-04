package br.com.avilar.seven;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

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
	      
	      System.out.println(respostaDaRequisicao);
	}

}
