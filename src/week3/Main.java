package week3;

import java.io.IOException;

import week1.Tokeniser;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Tokeniser tokeniser = new Tokeniser("cacm_small");
		tokeniser.parse();
		
		BooleanModel model = new BooleanModel();
		
		tokeniser.getDocuments().forEach((name,list)->{
			Document doc = new Document(name,list);
			model.addDocument(doc);
			System.out.println(model.corpusSize());
		});
		
		System.out.println(model.get("algebraic"));
		System.out.println(model.get("translators"));
		System.out.println(model.get("algorithm"));
		
	}
	
}
