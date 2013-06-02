package models;

import javax.persistence.Lob;

import play.db.ebean.Model;

/**
 * 
 * T
 * @author tmarthal
 *
 */
public class Source extends Model {

	String type;
	float lat;
	float lon;
	
	// e.g. pollution
	String levelType;
	// e.g. 5
	float level;
	
	@Lob
	String description;
}
