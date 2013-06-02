#!/usr/bin/python

from pykml import parser
import requests
from lxml import etree


doc = None
with open('files/airport-emissions-epa.kml') as f:
	doc = parser.parse(f)
print dir(doc)
print "ts=%s" % doc.Document.name
root = doc.getroot()
print "rt=%s" % root.Document.name

count = 0
for element in root.iter():
	count += 1
	if count > 0:
		break
	print "ee = %s" % etree.tostring(element)
