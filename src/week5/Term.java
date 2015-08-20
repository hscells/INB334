package week5;

/**
 * Term object which contains a string term
 * @author harryscells
 *
 */
public class Term {
	
	private String t;
	public int frequency;
	
	Term(String t) {
		this.t = t;
		this.frequency = 0;
	}
	
	public String get() {
		return t;
	}
	
	public int frequency() {
		return this.frequency;
	}
	
	public void setFrequency(int f) {
		this.frequency = f;
	}
}
