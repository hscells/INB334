package week5;

import java.util.HashMap;

import week3.DocumentList;

public interface Model {
	
	public HashMap<?, ?> getIndex();
	public HashMap<?, ?> getDocumentMap();
	
	public DocumentList query(String q); 
	
}
