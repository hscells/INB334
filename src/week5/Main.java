package week5;

import java.io.IOException;

import week1.Tokeniser;
import week3.Document;
import week3.DocumentList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Tokeniser tokeniser = new Tokeniser("cacm");
		tokeniser.parse();
		
		VectorSpaceModel model = new VectorSpaceModel();
		
		long startTime = System.currentTimeMillis();
		
		System.out.println("Adding Terms");
		tokeniser.getTerms().forEach((name, n) -> {
			model.addTerm(name,n);
		});
		
		System.out.println("Adding Documents");
		tokeniser.getDocuments().forEach((name, list) -> {
			Document doc = new Document(name, list);
			model.addDocument(doc);
		});

		System.out.println("Creatng Index");
		model.createIndex();
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		System.out.println(elapsedTime / 1000);
		
//		System.out.println(model.getIndex());
//		System.out.println(model.getDocumentMap());
		DocumentList query_results = model.query("carefully");
		System.out.println(query_results);
		System.out.println(query_results.get(0));
		System.out.println(query_results.get(0).getTermVector());
		
	}
	
}

