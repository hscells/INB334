package week5;

import java.util.HashMap;

import week3.Document;

/**
 * Term object which contains a string term
 * @author harryscells
 *
 */
public class Term {
	
	private String term;
	private double tfidf;
	private int frequency;
	private HashMap<Document, Integer> document_frequency = new HashMap<Document, Integer>();
	private int id;
	
	Term(String term, int frequency, int id) {
		this.term = term;
		this.frequency = frequency;
		this.tfidf = 0;
		this.id = id;
	}
	
	public void addDocument(Document document, int frequency) {
		document_frequency.put(document, frequency);
	}
	
	public int getFrequency() {
		return this.frequency;
	}
	
	public int getDocumentFrequency(){
		return this.document_frequency.size();
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setFrequency(int f) {
		this.frequency = f;
	}
	
	public void setTFIDF(double v) {
		this.tfidf = v;
	}
	
	public double getTFIDF() {
		return this.tfidf;
	}
	
	public String toString() {
		return this.term;
	}
	
	@Override
	public int hashCode()
	{
	    return this.term.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
	    return this.term.equals(o);
	}
}
