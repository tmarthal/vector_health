#!/usr/bin/python

import csv
import json

data = {}
with open('files/airport-emissions-epa.csv', 'rb') as f:
	reader = csv.reader(f)
	for row in reader:
		if reader.line_num == 1:
			continue
		if 'Airport' not in row[7]:
			continue
		#print row
		name = row[0]
		ll = (row[2], row[3])
		drow = data.get(name, {})
		pollution = drow.get('pollution', 0)
		drow['coord'] = ll
		drow['pollution'] = pollution + int(float(row[8]))
		data[name] = drow

print json.dumps(data, indent=2)
