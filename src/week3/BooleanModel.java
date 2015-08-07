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
				vec.add(1);
			} else { 
				vec.add(0);
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
	
	public BitSet get(String term) { 
		return index.get(term);
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
