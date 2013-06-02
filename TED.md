
We [gathered a large number of sources](https://pinboard.in/u:tedder42/t:vector-health/) before starting.

Pollution
---------
In this proof of concept, rather than be finegrained about /type/ of pollution, we are using a simple model that sums any given type into "tons of pollution per year".


* Airports: EPA, [airport pollution data](http://www.epa.gov/air/emissions/where.htm), 2008, CSV. Filtered out minor sources and transformed to a simple JSON format.


Affected sites
--------------

* Schools: [California Atlas/ESRI GNIS dataset](https://projects.atlas.ca.gov/frs/?group_id=277&release_id=8978), [600mb DBF (compressed to 12mb)](sourcer/School.dbf.gz), removed anything N of 34.5 lat to cut down on dataset size- still 1/2mb output.



Code used
---------
* python
  * csv
  * json
* dbfpy

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


