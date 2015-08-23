package week5;

/**
 * Term object which contains a string term
 * @author harryscells
 *
 */
public class Term {
	
	private String term;
	private double tfidf;
	private int frequency;
	
	Term(String term, int frequency) {
		this.term = term;
		this.frequency = frequency;
		this.tfidf = 0;
	}
	
	public int getFrequency() {
		return this.frequency;
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
}
