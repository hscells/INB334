package week2;

import java.io.IOException;
import java.util.List;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

public class Main {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		
		String serialisedClassifier = "classifiers/english.all.3class.distsim.crf.ser.gz";
		
		AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serialisedClassifier);
		
		String fileContents = IOUtils.slurpFile("cacm/CACM-0400.html");
		
		List<List<CoreLabel>> out = classifier.classify(fileContents);
		
		for (List<CoreLabel> sentence : out) {
			for (CoreLabel word : sentence) {
				System.out.println(word.word() + '_' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
			}
			System.out.println();
        }		
		
	}
}
