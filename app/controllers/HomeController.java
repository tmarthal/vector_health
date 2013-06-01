package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.map;

public class HomeController extends Controller {
	
	/**
	 * 
	 * @return
	 */
	public static Result index() {
		return ok(map.render());
	}

}
