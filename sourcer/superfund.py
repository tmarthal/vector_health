#!/usr/bin/python

import requests
import sys
import json

if not len(sys.argv) == 2:
	print "pass json as arg plzkthzbai"

req = requests.get("http://ofmpub.epa.gov/enviro/frs_rest_services.get_facilities", params={'program_output':'yes', 'output':'JSON', 'search_radius':'2', 'latitude83':'34.04', 'longitude83':'-118.22'})
print "url: %s" % req.url
out = req.json()

data = {}
print "res: %s" % len(out['Results'])
for site in out['Results']['FRSFacility']:
	name = site['FacilityName']
	ll = (site['Latitude83'], site['Longitude83'])
	data[name] = {'coord':ll,'desc':''}

with open(sys.argv[1], 'w') as f:
	f.write(json.dumps(data, indent=2, ensure_ascii=False))
	f.close()
