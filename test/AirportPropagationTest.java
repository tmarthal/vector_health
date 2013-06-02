import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
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
import org.apache.mahout.math.function.IntProcedure;
import org.apache.mahout.math.set.AbstractIntSet;
import org.apache.mahout.math.set.OpenIntHashSet;
import org.apache.mahout.vectorizer.encoders.Dictionary;
import org.apache.mahout.vectorizer.encoders.StaticWordValueEncoder;
import org.apache.mahout.vectorizer.encoders.WordValueEncoder;
import org.junit.Test;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntObjectMap;
import com.carrotsearch.hppc.IntObjectOpenHashMap;



//Here are the four data points:
//d1: c a a b c b c : 0
//d2: a b c a b c c : 0
//d3: d e f f d : 1
//d4: f d e d f : 1
//
//
// Classification looks like:
//  
//
//
//


/**
 * Run this test with the following arguments:
 * 
 * $> play "test-only TrivialExample1"
 * 
 *
 */
public class TrivialExample1 {
	
	
	@Test
	public void hello() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				IntObjectMap<BitSet> itemBits = new IntObjectOpenHashMap<BitSet>();
				final int[] items = getItemList(itemBits);
		
				// use items and itemBits for further analysis
		
				System.out.println("happy end is not printed, items: " + items.length);
			}
		});
		
	}

	// path to the dataset file
	private static final String filePath = "test/data/mushroom.dat";

	// dataset size parameters
	public static int n, m;

	private static int[] getDataset() throws IOException {

		// these variables will be reused below, in two file reads
		byte[] c = new byte[1024];
		int z, readChars, i = 0, j = 0, x = 0;

		// set the n and m dataset parameters
		InputStream is = new BufferedInputStream(new FileInputStream(filePath));
		try {
			out:
			while ((readChars = is.read(c)) != -1) {
				for (z = 0; z < readChars; z++) {
					// count the number of dataset columns in the line
					if (c[z] == ' ') j++;
					if (c[z] == '\n') {
						i++;
						// count the number of '\n' left in c array
						for (x = z + 1; x < readChars; x++) {
							if (c[x] == '\n') i++;
						}
						break out;
					}
				}
			}

			// set the number of dataset columns
			m = j;

			while ((readChars = is.read(c)) != -1) {
				for (z = 0; z < readChars; z++) {
					if (c[z] == '\n') i++;
				}
			}

			// set the number of dataset rows
			n = i;

		} finally { is.close(); }

		System.out.println("n = " + n + "; m = " + m);

		// initialize dataset
		int[] X = new int[n * m];

		// read dataset from file
		is = new BufferedInputStream(new FileInputStream(filePath));
		try {

			// reset i and j counters
			x = 0; i = 0; j = 0;

			while ((readChars = is.read(c)) != -1) {
				for (z = 0; z < readChars; z++) {
					if (c[z] == ' ') {
						X[i * m + j] = m * x + j;
						j++;
						x = 0;
					} else if (c[z] == '\n') {
						// go to the next row
						i++;
						// reset column
						j = 0;
					} else {
						x = 10 * x + Character.getNumericValue(c[z]);
					}
				}
			}

		} finally { is.close(); }

		System.out.println("returned " + X.length);
		return X;

	}

	public static int[] getItemList(IntObjectMap<BitSet> itemBits) {

		// get dataset
		int[] X = null;
		try {
			X = getDataset();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		// create the list of items
		IntArrayList hs = new IntArrayList();

		// create the set of distinct column values
//		IntSet columnValues = new IntOpenHashSet();
		AbstractIntSet columnValues = new FixedOpenIntHashSet();

		// create the list of item associated rows
		BitSet rows = new BitSet(n);

		// go through item values in X, s = items.size()
		int s = 0;
		for (int j = 0, x, i, rc, r; j < m; j++) {

System.out.println(j);			
			columnValues.clear();
			for (i = 0; i < n; i++) {

				// get the current matrix value
				x = X[i * m + j];

				System.out.println("i is " + i + " " + x);
System.out.println(columnValues.size());
final int xxxx = x;

//for (int i = columnValues.table.length; i-- > 0;) {
//    if (state[i] == FULL) {
//      if (!procedure.apply(table[i])) {
//        return false;
//      }
//    }
//  }

columnValues.forEachKey(
        new IntProcedure() {
          @Override
          public boolean apply(int iterKey) {
        	  System.out.println("iterating on key " + iterKey);
            return (xxxx != iterKey);
          }
        }
    );
System.out.println("finished interating");
				// pass over if such an element has been considered
				if (columnValues.contains(x)) {
					System.out.println(i + " " + j + " column values dcontain " + x);					
					
					continue;
				}
System.out.println("column values does not contain");					

				// count the repetition of the x value and
				// keep the track of associated rows
				rows.clear();
				rows.set(i);
				for (r = i + 1; r < n; r++) {
System.out.println("R " + r);					
					if (X[r * m + j] == x) rows.set(r);
				}
				rc = rows.cardinality();

				// drop items occurring in all rows (Uniform Support Property)
				if (rc == n) break;

				// no need to add a unique item to the column values list
				if (rc == 1) continue;

System.out.println("adding " + x);				
				columnValues.add(x);

System.out.println("done adding " + x);				
				// add item to the list
				hs.add(x);

				// save item information
				BitSet rowszip = (BitSet) rows.clone();
				itemBits.put(x, rowszip);

				s++; // increase the size of items array
System.out.println("increasing s to " + s);
			}
System.out.println("done with the j loop");

		}

		// cut
		int[] hszip = new int[s];
		System.arraycopy(hs.buffer, 0, hszip, 0, s);
		// sort
		Arrays.sort(hszip);

		return hszip;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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
	
	//@Test
	public void stochasticWeightTest() throws Exception {
		running(fakeApplication(), new Runnable() {
			public void run() {
				System.out.println("Hello");
            	System.out.println("hello");
            	try {
            		
            		StaticWordValueEncoder wordEncoder = new StaticWordValueEncoder("words");
            		wordEncoder.setProbes(1);
            		Map<String,Set<Integer>> traceDictionary = new HashMap<String,Set<Integer>>();
            		wordEncoder.setTraceDictionary(traceDictionary);
            		
            		// We have a total of 6 features: a, b, c, d, e, f 
            		int numFeatures = 6;
            		
            		
            		// The SGD algorithm
            		OnlineLogisticRegression learningAlgorithm = new OnlineLogisticRegression(2, numFeatures, new L1());

            		// The model output
            		ModelDissector md = new ModelDissector();
            		
            		// Here are the features from above 
            		List<String> d1Words = Arrays.asList(new String[]{"c", "a", "a", "b", "c", "b", "c"});
            		Vector d1 = TrivialExample1.encodeWordVector(numFeatures, d1Words, wordEncoder);
            		
            		learningAlgorithm.train(0, d1);
            		
            		md.update(d1, traceDictionary, learningAlgorithm);
            		List<Weight> d1Weights = md.summary(6);
            		for (Weight w : d1Weights) {
            			System.out.println("d1 " + w.getFeature() + " " + w.getWeight());
            		}
            		
            		
            		List<String> d2Words = Arrays.asList(new String[]{"a", "b", "c", "a", "b", "c", "c"});
            		Vector d2 = TrivialExample1.encodeWordVector(numFeatures, d2Words, wordEncoder);

            		learningAlgorithm.train(0, d2);

            		md.update(d2, traceDictionary, learningAlgorithm);
            		List<Weight> d2Weights = md.summary(6);
            		for (Weight w : d2Weights) {
            			System.out.println("d2 " + w.getFeature() + " " + w.getWeight());
            		}
            		
            		
            		// d e f f d
            		List<String> d3Words = Arrays.asList(new String[]{"d", "e", "f", "f", "d"});
            		Vector d3 = TrivialExample1.encodeWordVector(numFeatures, d3Words, wordEncoder);

            		learningAlgorithm.train(1, d3);

            		md.update(d3, traceDictionary, learningAlgorithm);
            		List<Weight> d3Weights = md.summary(6);
            		for (Weight w : d3Weights) {
            			System.out.println("d3 " + w.getFeature() + " " + w.getWeight());
            		}
            		
            		
            		
            		// Used to get the weights of a vector
            		List<String> a_list = Arrays.asList(new String[]{"a"});
            		Vector a = TrivialExample1.encodeWordVector(numFeatures, a_list, wordEncoder);
            		
            		
            		
            		System.out.println(learningAlgorithm.classifyNoLink(a));
            		Vector output = learningAlgorithm.classify(a);
            		System.out.println(output);
            		
            		
            		//ngexample.HelloTestCode.hello();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		});
	}

}
