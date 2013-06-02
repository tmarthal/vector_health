package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.map;

/**
 * This should contain all of actions for the mapping
 */
public class HomeController extends Controller {
	
	/**
	 * 
	 * @return
	 */
	public static Result index() {
		return ok(map.render());
	}

}
