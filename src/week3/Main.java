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
//			System.out.println(model.size());
		});
		
		System.out.println(model.query("algebraic"));
		System.out.println(model.query("translators"));
		System.out.println(model.query("algorithm"));
		System.out.println(model.query("algorithm AND rootfinder"));
		System.out.println(model.query("algorithm NOT rootfinder"));
		
	}
	
}
