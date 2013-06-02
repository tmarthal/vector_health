package models;

import play.db.ebean.Model;

/**
 * The transform information of the Source values
 * 
 * @author tmarthal
 *
 */
public class VectorField extends Model {

	// lat, lon value
	double[][] transform2d;
}
