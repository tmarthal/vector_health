
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/militarybase.json 'Military Base'
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/refinery.json 'Ethanol Biorefineries' 'Pipeline compressor station'  'Petroleum Refinery'
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/drycleaner.json 'Dry Cleaners - Perchloroethylene' 'Dry Cleaner - Petroleum Solvent/laundries'
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/oil_field.json 'Oil or Gas Field (On-shore)'
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/cremation.json "crematories - animal" "crematories - human"
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/airports.json "airport"
./general-csv.py files/epa-airports-crematories-drycleaners-gasstations-militarybases-petrolrefineries.csv.gz ../public/data/pollute/landfill.json 'Landfill' 'Municipal Waste Combustor'

./oil_wells.py files/oil_wells.dbf.gz ../public/data/pollute/_oil_wells.json
./superfund.py ../public/data/pollute/_superfund.json

./dbf.py files/School.dbf.gz ../public/data/affected/schools.json
./dbf.py files/Park.dbf.gz ../public/data/affected/parks.json
./dbf.py files/Hospital.dbf.gz ../public/data/affected/hospitals.json

