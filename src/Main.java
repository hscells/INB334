import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	private static int uniqueTerms = 0;

	public static void main(String[] args) throws IOException{
		
		PrintWriter writer = new PrintWriter("terms.txt", "UTF-8");
		Tokeniser tokeniser = new Tokeniser("cacm");
		tokeniser.parse();
		
		tokeniser.getTerms().keySet().forEach(term ->{
			writer.write(term + "\t" + tokeniser.getTerms().get(term) + "\n");
			if (tokeniser.getTerms().get(term) == 1) {
				uniqueTerms++;
			}
		});
		
		writer.close();
		
		System.out.println("Unique terms: " + uniqueTerms);
		System.out.println("Total terms: " + tokeniser.getTerms().size());
		System.out.println("Total documents: " + tokeniser.getDocuments().size());
		
		
	}
}
