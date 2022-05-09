package br.com.avilar.seven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsear {
	public static String[] parseToCorpo(String json) {
		
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
}
