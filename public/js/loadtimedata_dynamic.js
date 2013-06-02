// this doesnt work because the d3.json is asynchronous and i need to pass in the timestamp information
function loadTimeData() {
	var prefix = 'lines';
	
	var times = [1369958400000, 1369969200000, 1369980000000, 1369990800000, 1370001600000, 1370012400000, 1370023200000];
	
	for (var index=0; index<times.length; index++) {
		var filePath = "@routes.Assets.at("data/wind/")";
		var fullName = filePath+times[index]+".json";
		d3.json(fullName, function(data) {
			var timestamp = times[index];
			var arrayName = prefix+timestamp;
			window[arrayName] = [];
			console.log(fullName);
			console.log(arrayName);
			console.log(window[arrayName]);
		
			console.log("loading data " + timestamp);
			for (var k=0; k<data.length; k++) {
				var lat = data[k].coord[0];
				var lon = data[k].coord[1];
				var angle = data[k].angle;
				var strength = data[k].strength;
				
				// This is the maginitude of the vector
				var strengthWeight = 0.03*(strength / 30);
				
				
				// Rotate these points, assume that the 
				var weights = rotate2D(strengthWeight, 0, angle);
				
				var lineCoordinates = [
	    			new google.maps.LatLng(lat, lon),
	    			new google.maps.LatLng(lat+weights[0], lon+weights[1])
	  			];
				
				var line = new google.maps.Polyline({
	    			path: lineCoordinates,
	    			icons: [{
	      				icon: lineSymbol,
	      				offset: '100%'
	    			}],
	    			map: map,
	    			visible: false,
	  			});
	  			console.log(arrayName);
				window[arrayName].push(line);
			}
			console.log("done data " + arrayName);
			console.log(window[arrayName].length);
		});
	}
}
