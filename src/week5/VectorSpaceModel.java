package week5;

import java.util.BitSet;
import java.util.HashMap;

import week3.Document;
import week3.DocumentList;

/**
 * Implements the Boolean Model using the vector space model
 * @author harryscells
 *
 */
public class VectorSpaceModel implements Model{

	private HashMap<Term, BitSet> index = new HashMap<Term, BitSet>();
	private HashMap<Integer, Document> documentmap = new HashMap<Integer, Document>();
	int id = 0;
	
	VectorSpaceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Get the inverted index
	 * @return HashMap<Term, BitSet> index
	 */
	@Override
	public HashMap<Term, BitSet> getIndex(){
		return index;
	}

	
	/**
	 * Get the inverted index
	 * @return HashMap<Integer, Document> index
	 */
	@Override
	public HashMap<Integer, Document> getDocumentMap(){
		return documentmap;
	}
	
	public void addDocument(Document document) {
		BitSet v = new BitSet();
		index.forEach((key,value)->{
			if(document.contains(key.toString())) {
				v.set(key.getID());
				key.addDocument(document, document.count(key.toString()));
			}
		});
		document.setTermVector(v);
		documentmap.put(documentmap.size(), document);
	}
	
	
	/**
	 * Adds a term with it's frequency to the index
	 * @param term 		The actual term string
	 * @param frequency	The total frequency in all documents
	 */
	public void addTerm(String term, int frequency) {
		Term t = new Term(term, frequency, id++);
		index.put(t, new BitSet());
	}
	
	public void createIndex() {
		index.forEach((term,vec)->{
			documentmap.forEach((index, doc)->{
				if(doc.contains(term.toString())) {
					vec.set(index);
				}
			});
		});
	}
	
	public double calculateCosineSimilarity(Document d, Query q) {
		return 0;
	}
	
	public double calculateIDF(Term t) {
		return 0;
	}
	
	public double calculateTFIDF(double tf, double df, int num_docs) {
		return ((Math.log(tf) + 1) * Math.log(index.size()/num_docs)) / Math.sqrt(1/* lol what actually goes here? */);
	}

	@Override
	public DocumentList query(String q) {
		DocumentList docs = new DocumentList();
		documentmap.forEach((index, doc)->{
			if (doc.contains(q)) {
				docs.add(doc);
			}
		});
		return docs;
	}


}
