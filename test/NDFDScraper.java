import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Random;

import org.joda.time.DateTime;
import org.junit.Test;

import play.Logger;

import gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator;
import gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLPortType;

/**
 * 
 * National Digital Forecast Database scraper - SOAP client
 * 
 * whichClient=NDFDgen&lat=38.99&lon=-77.01&
 * listLatLon=&lat1=&lon1=&lat2=&lon2=&resolutionSub=&listLat1=&listLon1=&listLat2=&listLon2=&resolutionList=&endPoint1Lat=&endPoint1Lon=&endPoint2Lat=&endPoint2Lon=&listEndPoint1Lat=&listEndPoint1Lon=&listEndPoint2Lat=&listEndPoint2Lon=&zipCodeList=&listZipCodeList=&centerPointLat=&centerPointLon=&distanceLat=&distanceLon=&resolutionSquare=&listCenterPointLat=&listCenterPointLon=&listDistanceLat=&listDistanceLon=&listResolutionSquare=&citiesLevel=&listCitiesLevel=&sector=&gmlListLatLon=&featureType=&requestedTime=&startTime=&endTime=&compType=&propertyName=&product=time-series&
 * begin=2004-01-01T00%3A00%3A00&end=2017-06-01T00%3A00%3A00&Unit=e&wspd=wspd&wdir=wdir&Submit=Submit
 *
 * $> play "test-only NDFDScraper"
 *
 */
public class NDFDScraper {
	/**
	 * This test actually gets the grid points for the lat/lon boundary inside the Los Angeles Basin
	 * 
	 * These points can then be used to query various features using an alternate SOAP call
	 */
	//@Test
	public void testLatLonListLine() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				
				try
				{
					
					
					NdfdXMLPortType ndfdXMLPortType = new NdfdXMLLocator().getndfdXMLPort();
					
					// The example uses the following bounding box/time
					//Time 2010-01-01T00:00:00
					//Lat/lon 38.99,-77.02 39.70,-104.80 47.6,-122.30
					
					// Los Angeles Basin Random Bounding box coordinates
					//upper: 33.5, -117.5:
					//lower: 34.5, -118.4
					BigDecimal lat1 = new BigDecimal( 33.5);
					BigDecimal lon1 = new BigDecimal(-117.5);
					BigDecimal lat2 = new BigDecimal(34.5);
					BigDecimal lon2 = new BigDecimal(-118.4);
					
					String result = ndfdXMLPortType.latLonListLine(lat1, lon1, lat2, lon2);
					System.out.println(result);
					
					
					// Result here for the LA Bounding box:
					//<?xml version='1.0'?><dwml version='1.0' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='http://graphical.weather.gov/xml/DWMLgen/schema/DWML.xsd'><latLonList>33.499075,-117.471485 33.536155,-117.533861 33.580690,-117.542828 33.617735,-117.605273 33.654751,-117.667758 33.699265,-117.676787 33.736246,-117.739341 33.780745,-117.748406 33.817690,-117.811028 33.862175,-117.820128 33.899084,-117.882819 33.943554,-117.891953 33.980427,-117.954714 34.024883,-117.963883 34.061720,-118.026713 34.106162,-118.035917 34.142962,-118.098816 34.187389,-118.108055 34.224153,-118.171023 34.268566,-118.180298 34.305293,-118.243335 34.349691,-118.252646 34.386381,-118.315752 34.430764,-118.325098 34.467418,-118.388274 34.511785,-118.397655</latLonList></dwml>
					
				} catch (Exception ex) {
					Logger.warn(ex.getMessage());
				}
			}
		});
	}
	
	
	@Test
	public void testGenerateMockWindGridJSON() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				
				try
				{
					Random randomGenerator = new Random();
					//Seeded with the time, so as each individual JSON file is recreatable
					//randomGenerator.setSeed(1369958400000L);
					
					randomGenerator.setSeed(1370098800000L);
					
					
					NdfdXMLPortType ndfdXMLPortType = new NdfdXMLLocator().getndfdXMLPort();
					
					DateTime startTime = new DateTime("2010-01-01T00:00:00");
					DateTime endTime = new DateTime("2010-01-03T00:00:00");
					
					//Time 2010-01-01T00:00:00
					//Lat/lon 38.99,-77.02 39.70,-104.80 47.6,-122.30
					BigDecimal lat1 = new BigDecimal(38.99);
					BigDecimal lon1 = new BigDecimal(-77.02);
					BigDecimal lat2 = new BigDecimal(39.70);
					BigDecimal lon2 = new BigDecimal(-104.80);
					
					String latLonResult = "33.499075,-117.471485 33.536155,-117.533861 33.580690,-117.542828 33.617735,-117.605273 33.654751,-117.667758 33.699265,-117.676787 33.736246,-117.739341 33.780745,-117.748406 33.817690,-117.811028 33.862175,-117.820128 33.899084,-117.882819 33.943554,-117.891953 33.980427,-117.954714 34.024883,-117.963883 34.061720,-118.026713 34.106162,-118.035917 34.142962,-118.098816 34.187389,-118.108055 34.224153,-118.171023 34.268566,-118.180298 34.305293,-118.243335 34.349691,-118.252646 34.386381,-118.315752 34.430764,-118.325098 34.467418,-118.388274 34.511785,-118.397655";
					String[] coords = latLonResult.split(" ");
					//System.out.println("Found " + coords.length + " grid points");
					
					//Formatting the generated angle
					double factor = 1e5; 
					
					System.out.println("[");
					for (int i=0; i < coords.length; i++) {
						// coords[i] should be "{lat},{lon}" %d, %d
						String[] latLon = coords[i].split(",");
						//System.out.println("(" + latLon[0] + ", " + latLon[1] + ")");
						// angle b, to 5 decimals
						double randomAngle = Math.round(randomGenerator.nextDouble() * 2*Math.PI * factor) / factor;;
						// Random Strength between 1 and 30?
						double randomStrength = randomGenerator.nextInt(30);
						System.out.println(pointJSON(Double.valueOf(latLon[0]), Double.valueOf(latLon[1]), randomAngle, randomStrength, !(i==coords.length-1)));
					}
					System.out.println("]");
					
					String result = null; //	ndfdXMLPortType.gmlTimeSeries(listLatLon, startTime, endTime, compType, featureType, unit, propertyName);
					System.out.println(result);
					
				} catch (Exception ex) {
					Logger.warn(ex.getMessage());
				}
			}
		});
	}

	/**
	 * Create a JSON object from the various wind grid properties
	 * @param lat
	 * @param lon
	 * @param angle
	 * @param strength
	 * @return
	 */
	private static String pointJSON(Double lat, Double lon, Double angle, Double strength, boolean trailingComma) {
		return "{ \"coord\": [" + lat +"," + lon +"], \"angle\":" + angle +", \"strength\":"+strength + "}" + (trailingComma?",":"");
	}

	
	@Test
	public void testWindDirectionFeature() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				System.out.println("Actually scrape the wind direction and strength");
			}
		});
	}
}
