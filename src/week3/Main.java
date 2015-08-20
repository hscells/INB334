package week3;

import java.io.IOException;

import week1.Tokeniser;

public class Main {

	public static void main(String[] args) throws IOException {

		Tokeniser tokeniser = new Tokeniser("cacm");
		tokeniser.parse();

		BooleanModel model = new BooleanModel();

		// By adding the documents separately from the terms, it allows
		// the boolean model to more efficiently add terms, because it 
		// doesn't have to loop over each term every time a document is added.
		tokeniser.getDocuments().forEach((name, list) -> {
			Document doc = new Document(name, list);
			model.addDocument(doc);
		});

		tokeniser.getTerms().forEach((name, n) -> {
			model.addTerm(name);
		});

//		System.out.println(model.query("rootfinder"));
		System.out.println(model.query("algebraic"));
		System.out.println(model.query("translators"));
		System.out.println(model.query("algorithm"));
		System.out.println(model.query("algorithm AND rootfinder"));
		System.out.println(model.query("algorithm NOT rootfinder"));

	}

}
