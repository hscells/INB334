package week5;

import java.io.IOException;

import week1.Tokeniser;
import week3.Document;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Tokeniser tokeniser = new Tokeniser("cacm");
		tokeniser.parse();
		
		VectorSpaceModel model = new VectorSpaceModel();
		
		long startTime = System.currentTimeMillis();
		tokeniser.getDocuments().forEach((name, list) -> {
			Document doc = new Document(name, list);
			model.addDocument(doc);
		});

		tokeniser.getTerms().forEach((name, n) -> {
			model.addTerm(name);
		});
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		System.out.println(elapsedTime / 1000);
		
	}
	
}

