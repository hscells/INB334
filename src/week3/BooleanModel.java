package week3;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Implements the boolean model and inverted index structures.
 * @author harryscells
 *
 */
public class BooleanModel {

	private HashMap<String, BitSet> index = new HashMap<String, BitSet>();
	private HashMap<Integer, Document> documentmap = new HashMap<Integer, Document>();
	
	BooleanModel() {
		
	}
	
	/**
	 * Get the map of documents
	 * @return HashMap<Integer, Document> documentmap
	 */
	public HashMap<Integer, Document> getDocumentMap(){
		return documentmap;
	}
	
	/**
	 * Get the inverted index
	 * @return HashMap<String, BitSet> index
	 */
	public HashMap<String, BitSet> getIndex(){
		return index;
	}
	
	/**
	 * Create a vector for a term containing the current document references
	 * @param term The term to add
	 * @return  
	 */
	private BitSet createIndexVector(String term) {
		BitSet vec = new BitSet();
		documentmap.forEach((key,doc)->{
			if(doc.contains(term)) { 
				vec.set(key);
			}
		});
		return vec;
	}
	
	/**
	 * Adds a term to the index
	 * @param term the term to add
	 */
	public void addTerm(String term) { 
		BitSet vec = createIndexVector(term);
		index.put(term, vec);
	}
	
	/**
	 * Adds a document to the inverted index
	 * @param document the document object to add
	 */
	public void addDocument(Document document) {
		documentmap.put(documentmap.size(), document);
	}
	
	/**
	 * Gets the list of documents as a DocumentList by searching for a string
	 * @param term the term to search for
	 * @return DocumentList list of documents
	 */
	public DocumentList getDocumentsByTerm(String term) { 
		return getDocumentsByBitSet(index.get(term));
	}
	
	/**
	 * Gets the list of documents as a DocumentList by searching for a bit set
	 * @param b
	 * @return
	 */
	public DocumentList getDocumentsByBitSet(BitSet b) {
		DocumentList docs = new DocumentList();
		for(int i = 0; i < b.size(); i++) {
			if (b.get(i)) { docs.add(documentmap.get(i)); }
		}
		return docs;
	}
	
	/**
	 * Gets the number of terms in the model
	 * @return
	 */
	public int size(){
		return index.size();
	}
	
	/**
	 * Query the inverted index. Currently, acceptable queries include:
	 * [term]
	 * [term] and [term]
	 * [term] or [term]
	 * [term] not [term]
	 * @param q
	 * @return
	 */
	public DocumentList query(String q) {
		List<String> qtok = Arrays.asList(q.toLowerCase().split(" "));
		if (qtok.size() == 2 || qtok.size() > 3 || qtok.size() < 1) {
			new Exception("Not a valid query");
		} else {
			if (qtok.size() == 1) {
				return getDocumentsByTerm(qtok.get(0));
			} else if (qtok.get(1).equals("and")) {
				return logicalAnd(qtok.get(0),qtok.get(2));
			} else if (qtok.get(1).equals("or")) {
				return logicalOr(qtok.get(0),qtok.get(2));
			} else if (qtok.get(1).equals("not")) {
				return logicalNot(qtok.get(0),qtok.get(2));
			} else {
				new Exception("Not a valid logical operator");
			}
		}
		return null;
	}
	
	/**
	 * Logically AND two terms' bit sets together
	 * @param t1
	 * @param t2
	 * @return DocumentList of terms
	 */
	private DocumentList logicalAnd(String t1, String t2) {
		BitSet b = (BitSet) index.get(t1).clone();
		b.and(index.get(t2));
		return getDocumentsByBitSet(b);
	}
	
	/**
	 * Logically OR two terms' bit sets together
	 * @param t1
	 * @param t2
	 * @return DocumentList of terms
	 */	
	private DocumentList logicalOr(String t1, String t2){
		BitSet b = (BitSet) index.get(t1).clone();
		b.or(index.get(t2));
		return getDocumentsByBitSet(b);
	}
	
	/**
	 * Logically NOT two terms' bit sets together
	 * @param t1
	 * @param t2
	 * @return DocumentList of terms
	 */	
	private DocumentList logicalNot(String t1, String t2){
		BitSet b = (BitSet) index.get(t1).clone();
		b.andNot(index.get(t2));
		return getDocumentsByBitSet(b);
	}
	
}
