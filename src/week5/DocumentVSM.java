package week5;

import java.util.List;

public class DocumentVSM extends week3.Document{

	private float TF;
	private float IDF;
	
	DocumentVSM(String name, List<String> contents, float TF, float IDF) {
		super(name, contents);
		this.TF = TF;
		this.IDF = IDF;
	}

}
