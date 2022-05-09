package br.com.avilar.seven;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public abstract class APIClient{
	public static String ApiCliente(String key, String urlApi) throws IOException, InterruptedException, URISyntaxException {

		if (key == null)
		      throw new IllegalArgumentException("Coloque a key no argumento!");
		
		String url = urlApi;
	      URI uri = new URI(url.replace("<apiKey>", key));
	      HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

	      HttpClient client = HttpClient.newHttpClient();
	      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	      
	      String json = response.body();
	      
	      return json;
		
	}
}
