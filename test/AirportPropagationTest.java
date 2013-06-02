import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
import gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator;

import org.junit.Test;

/**
 * Run this test with the following arguments:
 * 
 * $> play "test-only AirportPropagationTest"
 * 
 *
 */
public class AirportPropagationTest {
	
	
	@Test
	public void hello() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				System.out.println("sup");
				
			}
		});
		
	}
}
