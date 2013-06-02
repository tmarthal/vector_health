#!/usr/bin/python

from dbfpy import dbf
#import dbf
import json


data = {}
db = dbf.Dbf("files/School.dbf")
for rec in db:
	# filter out other states
	if not 'CA' in rec['STATE_ALPH']:
		continue
	#print rec
	name = rec['FEATURE_NA']

	# filter out anything north of santa clarita
	if rec['PRIM_LAT_D'] > 34.5:
		continue
	ll = (rec['PRIM_LAT_D'], rec['PRIM_LONG1'])

	data[name] = {'coord':ll}

print json.dumps(data, indent=2, ensure_ascii=False)

