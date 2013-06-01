import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import org.junit.Test;


public class NewsGroupTests {
	@Test
	public void stochasticWeightTest() throws Exception {
		running(fakeApplication(), new Runnable() {
			public void run() {
				System.out.println("Hello");
            	System.out.println("hello");
            	try {
					//PredictiveInterestsService.hello();
            		//TrainNewsGroups
            		ngexample.TrainNewsGroups.TrainThisBitch("test/data/20news-bydate/20news-bydate-train");
            		
            		//ngexample.HelloTestCode.hello();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		});
	}
}
