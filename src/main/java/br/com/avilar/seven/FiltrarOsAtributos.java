package br.com.avilar.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiltrarOsAtributos {
	
public static List<String> filtraOsAtributosPelaLocalizacao(String[] corpo, int i) {
		
		return Stream.of(corpo).map(key -> key.split("\",\"")[i])
		        .map(val -> val.split(":\"")[1])
		        .map(element -> element.replaceAll("\"", ""))
		        .collect(Collectors.toList());	
	}

public static List<List<String>> filtraOsAtributosList(String[] corpo, ArrayList<Integer> arrList) {
	
	List<List<String>> listagem = new ArrayList<>();
	
	
	for (int i=0; i<arrList.size(); i++) {
		Integer a = arrList.get(i);
		listagem.add(Stream.of(corpo).map(key -> key.split("\",\"")[a])
        .map(val -> val.split(":\"")[1])
        .map(element -> element.replaceAll("\"", ""))
        .collect(Collectors.toList()));
	}
	
	return listagem;
}
}
