package week3;

import java.util.ArrayList;

public class DocumentList {

	private ArrayList<Document> list = new ArrayList<Document>();
	
	DocumentList() {
		
	}
	
	public void add(Document document) {
		list.add(document);
	}
	
	public ArrayList<Document> getList() { 
		return list;
	}
	
	public String toString() {
		return list.toString();
	}
	
}
