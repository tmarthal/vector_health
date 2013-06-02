
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
  * http://graphical.weather.gov/xml/index_image001.gif

* wrapup
  * code used
  * [https://pinboard.in/u:tedder42/t:vector-health/](data sources)
  * TOM: add your data sources


Pollution
---------
In this proof of concept, rather than be finegrained about /type/ of pollution, we are using a simple model that sums any given type into "tons of pollution per year".


* Airports: EPA, [airport pollution data](http://www.epa.gov/air/emissions/where.htm), 2008, CSV. Filtered out minor sources and transformed to a simple JSON format.
* Gas stations:
* Factories?
* Military bases?


Affected sites
--------------
These sites came from Cal-Atlas/ESRI, which was great for consistency. However, the files were in the ancient dBase format.

* Schools: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8978)
  * [600mb DBF (compressed to 12mb)](sourcer/School.dbf.gz), removed anything N of 34.5 lat to cut down on dataset size- still 1/2mb output.
* Parks: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8973)
* Hospitals: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8954)


Lessons learned
---------------
underestimated work (team size/GIS experience)
* GIS is HARD! shapefiles
* many dimensions: location, time, severity
* no uniform APIs. Many aren't open or require approval!
  * CA DMV maintains a great list, but it's firewalled



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


