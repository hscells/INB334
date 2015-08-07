package week3;

import java.util.List;

public class Document {
	
	private String name;
	private List<String> contents;
	
	Document(String name, List<String> contents) {
		this.name = name;
		this.contents = contents;
	}

	public String getName() {
		return this.name;
	}
	
	public Boolean contains(String term) {
		return contents.contains(term);
	}
	
	public List<String> getContents() {
		return this.contents;
	}
	
	public String toString(){
		return name;
	}
	
}
