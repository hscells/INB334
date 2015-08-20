package week5;

import java.util.BitSet;

import week3.BooleanModel;
import week3.Document;

/**
 * Implements the Boolean Model using the vector space model
 * @author harryscells
 *
 */
public class VectorSpaceModel extends BooleanModel{

	VectorSpaceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addDocument(Document document) {
		documentmap.put(documentmap.size(), document);
	}
	
	public void addTerm(String term) {
		index.put(term, new BitSet());
	}
	
	public float calculateCosineSimilarity(Document d, Query q) {
		return 0;
	}
	
	public float calculateIDF(Term t) {
		return 0;
	}

}
