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
	# filter out other states
	if not 'CA' in rec['STATE_ALPH']:
		continue
	#print rec
	name = rec['FEATURE_NA']

	# filter out anything north of santa clarita
	if rec['PRIM_LAT_D'] > 34.5:
		continue
	# filter out anything south or east of Fullerton
	if rec['PRIM_LAT_D'] < 33.5 or rec['PRIM_LONG1'] > -117.5:
		continue
	ll = (rec['PRIM_LAT_D'], rec['PRIM_LONG1'])

	data[name] = {'coord':ll,'desc':''}

with open(sys.argv[2], 'w') as f:
	f.write(json.dumps(data, indent=2, ensure_ascii=False))
	f.close()

