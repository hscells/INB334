package week3;

import java.util.List;

/**
 * Small helper class to provide a nice interface to store a document
 * @author harryscells
 *
 */
public class Document {
	
	private String name;
	private List<String> contents;
	
	/**
	 * Document
	 * @param name The filename of the document
	 * @param contents The contents of the document as a List
	 */
	public Document(String name, List<String> contents) {
		this.name = name;
		this.contents = contents;
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
	
}
