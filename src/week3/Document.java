package week3;

import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/**
 * Small helper class to provide a nice interface to store a document
 * @author harryscells
 *
 */
public class Document {
	
	private String name;
	private List<String> contents;
	private BitSet terms;
	
	/**
	 * Document
	 * @param name The filename of the document
	 * @param contents The contents of the document as a List
	 */
	public Document(String name, List<String> contents) {
		this.name = name;
		this.contents = contents;
		this.setTermVector(new BitSet());
	}
	
	public Boolean contains(String term) {
		return contents.contains(term);
	}
	
	public List<String> getContents() {
		return this.contents;
	}
	
	public String toString(){
		return this.name;
	}

	public BitSet getTermVector() {
		return this.terms;
	}

	public void setTermVector(BitSet vec) {
		this.terms = vec;
	}
	
	public int count(String term) {
		return Collections.frequency(this.contents, term);
	}
	
}
