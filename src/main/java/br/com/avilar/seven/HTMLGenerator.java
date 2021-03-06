package br.com.avilar.seven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HTMLGenerator{

public static void GeradordeHtml(String html) throws FileNotFoundException, Exception {
	
	PrintWriter gerarHtml = new PrintWriter(new File("topFilmes.html"));
	
	gerarHtml.write(html);
	gerarHtml.flush();
	gerarHtml.close();
}

public static void htmlTipos(List<Tipo> detalhesTipoFilme, List<Tipo> detalhesTipoSerie, List<Tipo> mixed) throws FileNotFoundException, Exception{
	

String head =
		"""
		<head>
			<meta charset=\"utf-8\">
			<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
			<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
				+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
		</head>
		""";
	

String cardTotal1 = "";
for (int i = 0; i<cardieiro(detalhesTipoFilme).size(); i++) {
	cardTotal1 = cardTotal1 + cardieiro(detalhesTipoFilme).get(i);
}

String cardTotal2 = "";
for (int i = 0; i<cardieiro(detalhesTipoSerie).size(); i++) {
	cardTotal2 = cardTotal2 + cardieiro(detalhesTipoSerie).get(i);
}

String cardTotalMixed = "";
for (int i = 0; i<cardieiro(detalhesTipoSerie).size(); i++) {
	cardTotalMixed = cardTotalMixed + cardieiro(mixed).get(i);
}

String html =
		"""
				<!DOCTYPE html>
					<html lang="pt-br">"""+ head + """
				<body>
						<article style="white-space: nowrap;overflow-x: scroll; overflow-y: hidden;">
				<h2>Top Maiores Filmes:</h2> </br>
				<p>Ordenado por nome</p>""" + cardTotal1 +"""
				</article>
						<article style="white-space: nowrap;overflow-x: scroll; overflow-y: hidden;">
				</br><h2>Top Maiores Series de TV:</h2> </br>
				<p>Ordenado por ano</p>""" + cardTotal2 +"""
				</article>
				<article style="white-space: nowrap;overflow-x: scroll; overflow-y: hidden;">
				</br><h2>Todos: </h2> </br>
				<p>Ordenado por nota</p>""" + cardTotalMixed +"""
				</article>
				</body>
				</html>
				""";

GeradordeHtml(html);
System.out.println("feito");
}


private static List<String> cardieiro(List<Tipo> detalhes) {
	
	List<String> card = new ArrayList<>();
	for (int i = 0; i < detalhes.size(); i++) {
		card.add("""
						<div class="card" style="width: 13rem; margin: 1rem; display: inline-block;">
						<img class="card-img-top" src="
						"""+ detalhes.get(i).getUrlImagem() + """
						" alt="Card image cap" loading="lazy">
						<div class="card-body">
						<h5 class="card-title" style="nowrap;overflow-x: scroll; overflow-y: hidden;">
						""" + detalhes.get(i).getTitulo() + """
								</h5>
								<p class="card-text">""" + detalhes.get(i).getAno() + """
								</p>
								</div>
								<ul class="list-group list-group-flush">
								<li class="list-group-item">
								nota: """ + detalhes.get(i).getNota() + """
										</li>
								<li class="list-group-item">
								ranking: """ + detalhes.get(i).getRanking() + """
										</li>
								<li class="list-group-item">
								""" + detalhes.get(i).tipo() + """
										</li>		
										</ul>
										</div>
										""");
	}
	
	return card;
}


}

