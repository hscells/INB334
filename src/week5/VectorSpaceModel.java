package week5;

import java.util.BitSet;
import java.util.HashMap;

import week3.BooleanModel;
import week3.Document;

/**
 * Implements the Boolean Model using the vector space model
 * @author harryscells
 *
 */
public class VectorSpaceModel extends BooleanModel{

	private HashMap<Term, BitSet> index = new HashMap<Term, BitSet>();
	
	VectorSpaceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addDocument(Document document) {
		documentmap.put(documentmap.size(), document);
	}
	
	/**
	 * Adds a term with it's frequency to the index
	 * @param term 		The actual term string
	 * @param frequency	The total frequency in all documents
	 */
	public void addTerm(String term, int frequency) {
		Term t = new Term(term, frequency);
		index.put(t, new BitSet());
	}
	
	public double calculateCosineSimilarity(Document d, Query q) {
		return 0;
	}
	
	public double calculateIDF(Term t) {
		return 0;
	}
	
	public double precalculateTFIDF(double tf, double df, int num_docs) {
		return ((Math.log(tf) + 1) * Math.log(index.size()/num_docs)) / Math.sqrt(1/* lol what actually goes here? */);
	}

}
