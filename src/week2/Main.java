package week2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		
		String newPath = "cacm_tokens";
		
		(new File(newPath)).mkdirs();
		
		Files.walk(Paths.get("cacm")).forEach(filePath -> {
			if (Files.isRegularFile(filePath)) {
				try {
					String fileContents = IOUtils.slurpFile(filePath.toString());
					List<List<CoreLabel>> out = classifier.classify(fileContents);
					PrintWriter writer = new PrintWriter(newPath + "/" + filePath.getFileName().toString(), "UTF-8");
					for (List<CoreLabel> sentence : out) {
						for (CoreLabel word : sentence) {
							writer.print(word.word() + '_' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
						}
			        }
					writer.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
