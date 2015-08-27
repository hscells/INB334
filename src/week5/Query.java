package week5;

import java.util.BitSet;

public class Query {
	
	private BitSet vector;
	
	Query(BitSet vector) {
		this.vector = vector;
	}
	
	public BitSet getQueryVector() {
		return this.vector;
	}

}
