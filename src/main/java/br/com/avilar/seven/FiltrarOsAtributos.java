package br.com.avilar.seven;

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
}
