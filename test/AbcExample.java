import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.mahout.classifier.sgd.L1;
import org.apache.mahout.classifier.sgd.ModelDissector;
import org.apache.mahout.classifier.sgd.ModelDissector.Weight;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.vectorizer.encoders.Dictionary;
import org.apache.mahout.vectorizer.encoders.StaticWordValueEncoder;
import org.apache.mahout.vectorizer.encoders.WordValueEncoder;
import org.junit.Test;



//Here are the data points:
//d1: a b c : 0
//d2: a b c : 0
//d3: d  : 1
//d4: d  : 1
//d5: b d : 1
//d6: b c : 0
//d7: b c : 0
//d8: b c : 0
//d9: c d : 1

// Classification looks like:
//  
//
//
//


/**
 * Run this test with the following arguments:
 * 
 * $> play "test-only AbcExample"
 * 
 *
 */
public class AbcExample {

	static Dictionary wordIndexDictionary = new Dictionary();
	
	private static Vector encodeWordVector(int totalFeatureCount, List<String> words, StaticWordValueEncoder encoder) {
		// Allocate the vector on construction, so the put() calls do not rehash the size
		RandomAccessSparseVector v = new RandomAccessSparseVector(totalFeatureCount, words.size());
		System.out.println("allocated vector : " + v.size() + " non-null: " + v.getNumNondefaultElements() + " listsize: " + words.size());

		for (String s : words) {

			// We get the index of the word string and then add that value to the vector
			encoder.addToVector(s, 1.0, v);
		}
		System.out.println(v);
		return v;
	}
	
	@Test
	public void stochasticWeightTest() throws Exception {
		running(fakeApplication(), new Runnable() {
			public void run() {
            	try {
            		StaticWordValueEncoder wordEncoder = new StaticWordValueEncoder("words");
            		wordEncoder.setProbes(1);
            		Map<String,Set<Integer>> traceDictionary = new HashMap<String,Set<Integer>>();
            		wordEncoder.setTraceDictionary(traceDictionary);
            		
            		// We have a total of 6 features: a, b, c, d 
            		int numFeatures = 5;
            		
            		
            		// The binary SGD algorithm
            		OnlineLogisticRegression learningAlgorithm = new OnlineLogisticRegression(2, numFeatures, new L1());

            		// The model output
            		ModelDissector md = new ModelDissector();
            		
            		//Here are the data points:
            		//d1: a b c : 0
            		//d2: a b c : 0
            		//d3: d  : 1
            		//d4: d  : 1
            		//d5: b d : 1
            		//d6: b c : 0
            		//d7: b c : 0
            		//d8: b c : 0
            		//d9: c d : 1
            		
            		
            		// Here are the features from above 
            		List<String> d1Words = Arrays.asList(new String[]{"a", "b", "c"});
            		Vector d1 = AbcExample.encodeWordVector(numFeatures, d1Words, wordEncoder);
            		List<String> d2Words = Arrays.asList(new String[]{"a", "b", "c"});
            		Vector d2 = AbcExample.encodeWordVector(numFeatures, d2Words, wordEncoder);
            		List<String> d3Words = Arrays.asList(new String[]{"d"});
            		Vector d3 = AbcExample.encodeWordVector(numFeatures, d3Words, wordEncoder);
            		List<String> d4Words = Arrays.asList(new String[]{"d"});
            		Vector d4 = AbcExample.encodeWordVector(numFeatures, d4Words, wordEncoder);
            		List<String> d5Words = Arrays.asList(new String[]{"b", "d"});
            		Vector d5 = AbcExample.encodeWordVector(numFeatures, d5Words, wordEncoder);
            		List<String> d6Words = Arrays.asList(new String[]{"b", "c"});
            		Vector d6 = AbcExample.encodeWordVector(numFeatures, d6Words, wordEncoder);
            		List<String> d7Words = Arrays.asList(new String[]{"b", "c"});
            		Vector d7 = AbcExample.encodeWordVector(numFeatures, d7Words, wordEncoder);
            		List<String> d8Words = Arrays.asList(new String[]{"b", "c"});
            		Vector d8 = AbcExample.encodeWordVector(numFeatures, d8Words, wordEncoder);
            		List<String> d9Words = Arrays.asList(new String[]{"c", "d"});
            		Vector d9 = AbcExample.encodeWordVector(numFeatures, d9Words, wordEncoder);
            		
            		learningAlgorithm.train(0, d1);
            		learningAlgorithm.train(0, d2);
            		learningAlgorithm.train(1, d3);
            		learningAlgorithm.train(1, d4);
            		learningAlgorithm.train(1, d5);
            		learningAlgorithm.train(0, d6);
            		learningAlgorithm.train(0, d7);
            		learningAlgorithm.train(0, d8);
            		learningAlgorithm.train(1, d9);

            		md.update(d1, traceDictionary, learningAlgorithm);
            		List<Weight> d1Weights = md.summary(6);
            		for (Weight w : d1Weights) {
            			System.out.println("d1 " + w.getFeature() + " " + w.getWeight());
            		}
            		
            		
            		
            		// Used to get the weights of a vector
            		List<String> a_list = Arrays.asList(new String[]{"a"});
            		Vector a = AbcExample.encodeWordVector(numFeatures, a_list, wordEncoder);
            		
            		List<String> d_list = Arrays.asList(new String[]{"d"});
            		Vector d = AbcExample.encodeWordVector(numFeatures, d_list, wordEncoder);
            		
            		System.out.println(a);
            		Vector output = learningAlgorithm.classify(a);
            		System.out.println(output);
            		
            		System.out.println(d);
            		Vector doutput = learningAlgorithm.classify(d);
            		System.out.println(doutput);
 				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		});
	}

}
