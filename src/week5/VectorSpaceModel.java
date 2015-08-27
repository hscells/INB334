package week5;

import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

import week3.Document;
import week3.DocumentList;

/**
 * Implements the Boolean Model using the vector space model
 * @author harryscells
 *
 */
public class VectorSpaceModel implements Model{

	private List<Term> terms;
	private HashMap<Integer, BitSet> index = new HashMap<Integer, BitSet>();
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
	public HashMap<Integer, BitSet> getIndex(){
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
				v.set(key);
				terms.get(key).addDocument(document, document.count(key.toString()));
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
		index.put(t.getID(), new BitSet());
		terms.add(t);
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
		BitSet v = (BitSet) d.getTermVector().clone();
		v.and(q.getQueryVector());
		double sum = 0;
		v.stream().forEach(index->{
			// wtf goes here 
		});
		return 0;
	}
	
	public double calculateIDF(Term t) {
		return Math.log(index.size()/t.getDocumentFrequency());
	}
	
	
	public double calculateTFIDF(Term t) {
		return ((Math.log(t.getDocumentFrequency()) + 1) * this.calculateIDF(t)) / Math.sqrt(Math.pow(((Math.log(t.getDocumentFrequency()) + 1) * this.calculateIDF(t)), 2));
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
