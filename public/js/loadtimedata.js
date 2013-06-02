// Such a hack, copy+paste for the time values... :(
function loadTimeData(filePath) {
	lines1369958400000 = [];
	d3.json(filePath+"1369958400000.json", function(data) {
		console.log("loading 1369958400000 data");
		for (var k=0; k<data.length; k++) {
			var lat = data[k].coord[0];
			var lon = data[k].coord[1];
			var angle = data[k].angle;
			var strength = data[k].strength;
			
			// This is the maginitude of the vector
			var strengthWeight = 0.03*(strength / 30);
			
			
			// Rotate these points, assume that the angle is position from 0radians at [1,0]  
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
			lines1369958400000.push(line);
		}
		console.log("done lines1369958400000 data");
		console.log(lines1369958400000.length);
	});
	
	lines1369969200000 = [];
	d3.json(filePath+"1369969200000.json", function(data) {
		console.log("loading 1369969200000 data");
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
			lines1369969200000.push(line);
		}
	});
	
	lines1369980000000 = [];
	d3.json(filePath+"1369980000000.json", function(data) {
		console.log("loading 1369980000000 data");
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
			lines1369980000000.push(line);
		}
	});
	
	lines1369990800000 = [];
	d3.json(filePath+"1369990800000.json", function(data) {
		console.log("loading 1369990800000 data");
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
			lines1369990800000.push(line);
		}
	});


	lines1370001600000 = [];
	d3.json(filePath+"1370001600000.json", function(data) {
		console.log("loading 1370001600000 data");
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
			lines1370001600000.push(line);
		}
	});
	
	 
	lines1370034000000 = [];
	d3.json(filePath+"1370034000000.json", function(data) {
		console.log("loading 1370034000000 data");
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
			lines1370034000000.push(line);
		}
	});
	
	
	lines1370044800000 = [];
	d3.json(filePath+"1370044800000.json", function(data) {
		console.log("loading 1370044800000 data");
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
			lines1370044800000.push(line);
		}
	});
	
	lines1370055600000 = [];
	d3.json(filePath+"1370055600000.json", function(data) {
		console.log("loading 1370055600000 data");
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
			lines1370055600000.push(line);
		}
	});
	
	lines1370077200000 = [];
	d3.json(filePath+"1370077200000.json", function(data) {
		console.log("loading 1370077200000 data");
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
			lines1370077200000.push(line);
		}
	});
	
	lines1370088000000 = [];
	d3.json(filePath+"1370088000000.json", function(data) {
		console.log("loading 1370088000000 data");
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
			lines1370088000000.push(line);
		}
	});
	
	lines1370109600000 = [];
	d3.json(filePath+"1370109600000.json", function(data) {
		console.log("loading 1370109600000 data");
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
			lines1370109600000.push(line);
		}
	});
	
	lines1370120400000 = [];
	d3.json(filePath+"1370120400000.json", function(data) {
		console.log("loading 1370120400000 data");
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
			lines1370120400000.push(line);
		}
	});
	
	lines1370131200000 = [];
	d3.json(filePath+"1370131200000.json", function(data) {
		console.log("loading 1370131200000 data");
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
			lines1370131200000.push(line);
		}
	});
	
	
	//
	lines1370012400000 = [];
	d3.json(filePath+"1370012400000.json", function(data) {
		console.log("loading 1370012400000 data");
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
			lines1370012400000.push(line);
		}
	});
	
	//
	lines1370023200000 = [];
	d3.json(filePath+"1370023200000.json", function(data) {
		console.log("loading 1370023200000 data");
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
			lines1370023200000.push(line);
		}
	});
	
	//
	lines1370066400000 = [];
	d3.json(filePath+"1370066400000.json", function(data) {
		console.log("loading 1370066400000 data");
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
			lines1370066400000.push(line);
		}
	});
	
	//
	lines1370098800000 = [];
	d3.json(filePath+"1370098800000.json", function(data) {
		console.log("loading 1370098800000 data");
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
			lines1370098800000.push(line);
		}
	});
}



