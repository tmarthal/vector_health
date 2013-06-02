import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.math.BigDecimal;
import java.util.Locale;

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
 */
public class NDFDScraper {
	//@Test
	public void testLatLonListLine() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				
				try
				{
					NdfdXMLPortType ndfdXMLPortType = new NdfdXMLLocator().getndfdXMLPort();
					
					//Time 2010-01-01T00:00:00
					//Lat/lon 38.99,-77.02 39.70,-104.80 47.6,-122.30
					BigDecimal lat1 = new BigDecimal(38.99);
					BigDecimal lon1 = new BigDecimal(-77.02);
					BigDecimal lat2 = new BigDecimal(39.70);
					BigDecimal lon2 = new BigDecimal(-104.80);
					
					String result = ndfdXMLPortType.latLonListLine(lat1, lon1, lat2, lon2);
					System.out.println(result);
					
				} catch (Exception ex) {
					Logger.warn(ex.getMessage());
				}
			}
		});
	}
	
	
	@Test
	public void testWindDirectionFeature() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				
				try
				{
					NdfdXMLPortType ndfdXMLPortType = new NdfdXMLLocator().getndfdXMLPort();
					
					DateTime startTime = new DateTime("2010-01-01T00:00:00");
					DateTime endTime = new DateTime("2010-01-03T00:00:00");
					
					//Time 2010-01-01T00:00:00
					//Lat/lon 38.99,-77.02 39.70,-104.80 47.6,-122.30
					BigDecimal lat1 = new BigDecimal(38.99);
					BigDecimal lon1 = new BigDecimal(-77.02);
					BigDecimal lat2 = new BigDecimal(39.70);
					BigDecimal lon2 = new BigDecimal(-104.80);
					
					
					
					String result = null; //	ndfdXMLPortType.gmlTimeSeries(listLatLon, startTime, endTime, compType, featureType, unit, propertyName);
					System.out.println(result);
					
				} catch (Exception ex) {
					Logger.warn(ex.getMessage());
				}
			}
		});
	}

	

}
