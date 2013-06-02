#!/usr/bin/python

import csv
import json
import sys
import gzip

if not len(sys.argv) > 3:
	print "pass csv, json, and source types as args plzkthzbai"

f = None
if sys.argv[1].endswith('.gz'):
	f = gzip.open(sys.argv[1])
else:
	f = open(sys.argv[1])

data = {}
skips = set()
reader = csv.reader(f)
for row in reader:

	# skip header
	if reader.line_num == 1:
		continue
	if row[7].lower() not in map(lambda x: x.lower(), sys.argv[3:]):
		skips.add(row[7])
		continue
	else:
		print "found: %s" % row[7]

	#print row
	name = row[0]

	latlon = ( float(row[2]), float(row[3]) )
	print "ll: %s" % str(latlon)
	# filter out anything north of santa clarita
	if latlon[0] > 34.5:
		print "too far north"
		continue
	# filter out anything south or east of Fullerton
	if latlon[0] < 33.5 or latlon[1] > -117.5:
		print "too far south/east: %s" % str(latlon)
		continue

	drow = data.get(name, {})
	pollution = drow.get('pollution', 0)
	drow['coord'] = latlon
	drow['pollution'] = pollution + int(float(row[8]))
	data[name] = drow

print "done parsing. skips: %s" % skips

with open(sys.argv[2], 'w') as f:
	f.write(json.dumps(data, indent=2, ensure_ascii=False))
	f.close()
