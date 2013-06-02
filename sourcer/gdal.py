#!/usr/bin/python

from osgeo import gdal
from osgeo import ogr
from gdalconst import *

#print dir(gdal)

gdal.UseExceptions()
dataset = ogr.GetDriverByName('KML').Open('files/airport-emissions-epa.kml')
layer = dataset.GetLayerByIndex(0)
print layer.GetFeatureCount()

data = {}

count = 0
feature = layer.GetNextFeature()
while feature:
	count += 1
	print feature.DumpReadable()
	print "nn=%s" % feature.GetFieldAsString('name').split(':')[0]
	feature = layer.GetNextFeature()
	if count > 5: break
