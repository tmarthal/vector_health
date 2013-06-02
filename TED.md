
We [gathered a large number of sources](https://pinboard.in/u:tedder42/t:vector-health/) before starting.

todo
----
* icons: http://thenounproject.com/
* submit: http://hackforla.challengepost.com/submissions/new
* city planning/predictive analysis
* description box of boyle heights school showing pollution history/30 days

demo/presentation basics
------------------------
* thesis: we are data scientists, we are agnostic about the type of data. if we have access, we can help communities in the same way we help businesses.
* we used the Agile/Lean Startup style: small team, iterate to find answers.
* here's a map
  * (zoom in a little) here's schools/etc on a map
  * (zoom in a little) here are factories/polluters on a map
  * (zoom in a little) here's what that means for Boyle heights
  * show wind layer
* future: guide community planners to make data-driven decisions

* problems
  * data closed, difficult to access, many different formats
  * fragmentation of data (data scientists don't care about LA City political boundaries, we are all LA)
  * must fuse layers between departments, city/county/state/federal sources
  * presentation/ca-dmv-no-gis-access.png
	* presentation/methane.jpg
  * http://graphical.weather.gov/xml/index_image001.gif

* wrapup
  * code used
  * [https://pinboard.in/u:tedder42/t:vector-health/](data sources)
  * TOM: add your data sources


Pollution
---------
In this proof of concept, rather than be finegrained about /type/ of pollution, we are using a simple model that sums any given type into "tons of pollution per year".

* ICONS FOR TOM: http://thenounproject.com/tag/pollution/


* Sources with pollutants:
  * Airports: EPA, [airport pollution data](http://www.epa.gov/air/emissions/where.htm), 2008, CSV. Filtered out minor sources and transformed to a simple JSON format.
* Gas stations:
* Factories?
* Military bases?

* Location-only sources:
  * [ico](http://thenounproject.com/noun/poison/#icon-No3044)/[ico](http://thenounproject.com/noun/oil/#icon-No4175) [Superfund sites](http://ofmpub.epa.gov/enviro/frs_rest_services.get_facilities?program_output=yes&output=JSON&search_radius=5&latitude83=34.03&longitude83=-118.2&pgm_sys_acrnm=CERCLIS), REST/JSON
	* [ico](http://thenounproject.com/noun/oil/#icon-No8497)/[ico](http://thenounproject.com/noun/oil/#icon-No8497) [Oil wells](http://www.conservation.ca.gov/dog/maps/Pages/GISMapping2.aspx), DBF




Affected sites
--------------
These sites came from Cal-Atlas/ESRI, which was great for consistency. However, the files were in the ancient dBase format.

* Schools: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8978)
  * [600mb DBF (compressed to 12mb)](sourcer/School.dbf.gz), removed anything N of 34.5 lat to cut down on dataset size- still 1/2mb output.
* Parks: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8973)
* Hospitals: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8954)


Sources attempted but scrapped after much effort
------------------------------------------------
* [EPA FRS REST](http://www.epa.gov/enviro/html/fii/RESTServices.htm) - many listings but little useful data. For example, [schools, libraries, and chrome-plating factories have the same descriptions and zero pollutant information](http://ofmpub.epa.gov/enviro/frs_rest_services.get_facilities?program_output=yes&output=JSON&search_radius=1&latitude83=34.03&longitude83=-118.2).
* County of Los Angeles: [landfills producting methane](http://dpw.lacounty.gov/general/spatiallibrary/metadata.cfm?path=MethaneProducingLandfills.htm&zip=Methane_Producing_Landfills.zip), April 2012, DBF. Doesn't contain geocoding, which takes work.
  * City's data website was dead, cached version didn't look very promising.

Lessons learned
---------------
underestimated work (team size/GIS experience)
* GIS is HARD! shapefiles
* many dimensions: location, time, severity
* no uniform APIs. Many aren't open or require approval!
  * CA DOT maintains [a great list](http://www.dot.ca.gov/hq/tsip/gis/datalibrary/gisdatalibrary.html), but no public access.



Code used
---------
* python
  * csv
  * json
* [dbfpy](http://dbfpy.sourceforge.net/)

Code attempted but scrapped
---------------------------
* dbf: unmaintained, wouldn't work
* pyDBF: unmaintained, wouldn't work
* osgeo: too much work to parse KML, data was embedded as an image.
  * gdal
  * ogr
  * gdalconst
* pykml: who wants to fuss with XML trees?
  * lxml


