#!/usr/bin/python

from dbfpy import dbf
#import dbf
import json
import sys
import gzip

if not len(sys.argv) == 3:
	print "pass dbf and json as args plzkthzbai"

fh = None
if sys.argv[1].endswith('.gz'):
	fh = gzip.open(sys.argv[1])
else:
	fh = open(sys.argv[1])

data = {}
for rec in dbf.Dbf(fh):
	l = []
	rec['LEASENAME'] and l.append(rec['LEASENAME'])
	rec['OPERATORNA'] and l.append(rec['OPERATORNA'])
	name = ' - '.join(l)

	l = []
	active = 'Not active'
	if rec['ACTIVEWELL'] == 'Y':
		active = 'Active'
	l.append(active)
	if not rec['DIRECTIONA'] == 'Unknown':
		l.append(rec['DIRECTIONA'])
	field = '%s field' % rec['FIELDNAME']
	if rec['FIELDNAME'] == 'Any Field':
		field = 'unknown field'
	l.append(field)
	desc = ', '.join(l)
	#desc = '%s%s, %s field' % (active, directionality, rec['FIELDNAME'])

	latlon = (rec['LATITUDE'], rec['LONGITUDE'])
	# filter out anything north of santa clarita
	if latlon[0] > 34.5:
		continue
	# filter out anything south or east of Fullerton
	if latlon[0] < 33.5 or latlon[1] > -117.5:
		continue


	data[name] = {'coord':latlon,'desc':desc}

with open(sys.argv[2], 'w') as f:
	f.write(json.dumps(data, indent=2, ensure_ascii=False))
	f.close()

