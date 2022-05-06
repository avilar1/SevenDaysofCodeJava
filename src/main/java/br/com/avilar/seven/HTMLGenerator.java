package br.com.avilar.seven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HTMLGenerator{

public static void GeradordeFilmes(String html) throws FileNotFoundException, Exception {
	
	PrintWriter gerarHtml = new PrintWriter(new File("topFilmes.html"));
	
	gerarHtml.write(html);
	gerarHtml.flush();
	gerarHtml.close();
}

public static void htmlFilmes(List<String> titulos, List<Filmes> detalhesFilmes) throws FileNotFoundException, Exception{
	
List<String> card = new ArrayList<>();

String head =
		"""
		<head>
			<meta charset=\"utf-8\">
			<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
			<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
				+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
		</head>
		""";
		
 for (int i = 0; i < titulos.size(); i++) {
	card.add("""
					<div class="card" style="width: 13rem; margin: 1rem; display: inline-block;">
					<img class="card-img-top" src="
					"""+ detalhesFilmes.get(i).getUrlImagem() + """
					" alt="Card image cap">
					<div class="card-body">
					<h5 class="card-title" style="nowrap;overflow-x: scroll; overflow-y: hidden;">
					""" + detalhesFilmes.get(i).getTitulo() + """
							</h5>
							<p class="card-text">""" + detalhesFilmes.get(i).getAno() + """
							</p>
							</div>
							<ul class="list-group list-group-flush">
							<li class="list-group-item">
							nota: """ + detalhesFilmes.get(i).getNota() + """
									</li>
							<li class="list-group-item">
							ranking: """ + detalhesFilmes.get(i).getRanking() + """
									</li>		
									</ul>
									</div>
									""");
}

String cardTotal = "";
for (int i = 0; i<card.size(); i++) {
	cardTotal = cardTotal + card.get(i);
}

String html =
		"""
				<!DOCTYPE html>
					<html lang="pt-br">"""+ head + """
				<body>
						<main style="white-space: nowrap;overflow-x: scroll; overflow-y: hidden;">
				""" + cardTotal + """
				</main>
				</body>
				</html>
				""";

GeradordeFilmes(html);
System.out.println("feito");
}


}

