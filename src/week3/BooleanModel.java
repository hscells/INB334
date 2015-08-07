package week3;

import java.util.HashMap;
import java.util.Map;
import java.util.BitSet;
import java.util.stream.Stream;

public class BooleanModel {

	private HashMap<String, BitSet> index = new HashMap<String, BitSet>();
	private HashMap<Integer, Document> documentmap = new HashMap<Integer, Document>();
	
	BooleanModel() {
		
	}
	
	public HashMap<Integer, Document> getDocumentMap(){
		return documentmap;
	}
	
	public HashMap<String, BitSet> getIndex(){
		return index;
	}
	
	private void addDocumentToIndex(Document doc) {
		doc.getContents().forEach(term->{
			if (!index.containsKey(index)){
				addTerm(term);
			}
		});
		index.forEach((name,bitset)->{
			if (doc.contains(name)) {
				
			}
		});
	}
	
	private BitSet createIndexVector(String term) {
		BitSet vec = new BitSet();
		Stream<Map.Entry<Integer, Document>> sorted = documentmap.entrySet().stream().sorted(Map.Entry.comparingByKey());
		sorted.forEach(doc->{
			if(doc.getValue().contains(term)) { 
				vec.set(doc.getKey());
			}
		});
		return vec;
	}
	
	public void addTerm(String term) { 
		BitSet vec = createIndexVector(term);
		index.put(term, vec);
	}
	
	public void addDocument(Document document) {
		documentmap.put(documentmap.size(), document);
		addDocumentToIndex(document);
	}
	
	public DocumentList get(String term) { 
		DocumentList docs = new DocumentList();
		BitSet l = index.get(term);
		for(int i = 0; i < l.size(); i++) {
			if (l.get(i)) { docs.add(documentmap.get(i)); }
		}
		return docs;
	}
	
	public int corpusSize(){
		return documentmap.size();
	}
	
	public int size(){
		return index.size();
	}
	
	public void query(String q) {
		
	}
	
	private void logicalAnd(){
		
	}
	
	private void logicalOr(){
		
	}
	
	private void logicalNot(){
		
	}
	
}
