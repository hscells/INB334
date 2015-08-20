package week5;

import java.util.List;

public class DocumentVSM extends week3.Document{

	private float TF;
	private float IDF;
	
	DocumentVSM(String name, List<String> contents, float TF, float IDF) {
		super(name, contents);
		this.setTF(TF);
		this.setIDF(IDF);
	}

	public float getTF() {
		return TF;
	}

	public void setTF(float tF) {
		TF = tF;
	}

	public float getIDF() {
		return IDF;
	}

	public void setIDF(float iDF) {
		IDF = iDF;
	}

}
