import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
	
	private static int uniqueTerms = 0;

	public static void main(String[] args) throws IOException{
		
		HashMap<String, List<String>> documents = new HashMap<String, List<String>>();
		HashMap<String, Integer> terms = new HashMap<String, Integer>();
		
		Files.walk(Paths.get("cacm")).forEach(filePath -> {
			if (Files.isRegularFile(filePath)) {
				try {
					documents.put(filePath.toString(), Files.readAllLines(filePath));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});	
		
		documents.keySet().forEach(document-> {
			documents.get(document).forEach(lines -> {
				lines = lines.replaceAll("<.*>", "");
				lines = lines.replaceAll("[.,/'\'+=*[(][)]<>]+\"]+", "");
				lines = lines.replaceAll("[\t\n]+", "");
				lines = lines.replaceAll(" +", " ");
				lines = lines.toLowerCase();
				String[] tokens = lines.split(" ");
				for (int i = 0; i < tokens.length; i++) {
					if (!terms.containsKey(tokens[i])) {
						terms.put(tokens[i], 1);
					} else {
						terms.put(tokens[i], terms.get(tokens[i]) + 1);
					}
				}
			});
		});
		
		terms.keySet().forEach(term ->{
			if (terms.get(term) == 1) {
				uniqueTerms++;
			}
		});
		System.out.println("Unique terms: " + uniqueTerms);
		System.out.println("Total terms: " + terms.size());
		System.out.println("Total documents: " + documents.size());
		
	}
}
