
We [gathered a large number of sources](https://pinboard.in/u:tedder42/t:vector-health/) before starting.

todo
----
* icons: http://thenounproject.com/
* submit: http://hackforla.challengepost.com/submissions/new

Pollution
---------
In this proof of concept, rather than be finegrained about /type/ of pollution, we are using a simple model that sums any given type into "tons of pollution per year".


* Airports: EPA, [airport pollution data](http://www.epa.gov/air/emissions/where.htm), 2008, CSV. Filtered out minor sources and transformed to a simple JSON format.
* Gas stations:
* Factories?
* Military bases?


Affected sites
--------------

* Schools: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8978), [600mb DBF (compressed to 12mb)](sourcer/School.dbf.gz), removed anything N of 34.5 lat to cut down on dataset size- still 1/2mb output.
* Parks: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8973), 
* Hospitals: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8954), 


Lessons learned
---------------
underestimated work (team size/GIS experience)
* GIS is HARD! shapefiles
* many dimensions: location, time, severity
* no uniform APIs. Many aren''t open or require approval!



Code used
---------
* python
  * csv
  * json
* [dbfpy](http://dbfpy.sourceforge.net/)

Code attempted but scrapped
---------------------------
* dbf: unmaintained, wouldn''t work
* pyDBF: unmaintained, wouldn''t work
* osgeo: too much work to parse KML, data was embedded as an image.
  * gdal
  * ogr
  * gdalconst
* pykml: who wants to fuss with XML trees?
  * lxml


