<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<link rel="icon" type="image/gif/png" href="contacts-xxl.png">
<title>Crime Prediction</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="plugins/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="plugins/AdminLTE.min.css">
<link rel="stylesheet" href="plugins/_all-skins.min.css">
<link rel="stylesheet" href="plugins/morris/morris.css">
<link rel="stylesheet" href="plugins/alert/sweetalert.css">
<script type="text/javascript">
	window.onload = function() {
		onplageLoad();
	};
</script>
</head>
<style>
html, body {
	background-image: url("wallpaper1 (4).jpg");
	background-size: cover;
}

h2, h1 {
	font-size: 30px;
	font-family: Verdana;
	color: white;
	font-family: Verdana;
}

label {
	color: white;
}

#resultMessage {
	font-size: 20px;
	font-family: serif;
	color: white;
}
</style>
<body>
	<div class="container">
		<h1>
			Data Mining <small>technology</small>
		</h1>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">CrimeForcast</a>
				</div>
				<ul class="nav navbar-nav">

					<li role="presentation"><a onclick="homeSubmit()">Home</a></li>
					<li role="presentation" class="active"><a onclick="cimeprediction()">Crime
							forecast</a></li>
					<li role="presentation"><a onclick="viewmap()">Map View</a></li>
					<li class="dropdown" class="active"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Other <span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#" onclick="keralarecords()">View Kerala
									Records</a></li>
							<li class="divider"></li>
							<li ><a href="#" onclick="adminregister()">Admin
									Registration</a></li>
							<li><a href="#" onclick="caseregister()">Case
									Registration</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" onclick="logout()"><span
							class="fa fa-fw fa-unlock"></span> Log out</a></li>
				</ul>
			</div>
		</nav>
		<section class="content-header">
			<h2>Crime prediction using the history data set</h2>
		</section>
		<section class="content">
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<label>Select State</label> <select id="statenames"
							onchange="getAllDistrcitName()" class="form-control">
							<option>-select-</option>
							<c:forEach var="userdata" items="${sessionScope.localDistrict}">
								<option>${userdata}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Select District</label> <select id="districtnames"
							onchange="getAllPlaceName()" class="form-control">
							<option>-select-</option>
						</select>

					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Select Place</label> <select id="placenames"
							class="form-control">
							<option>-select-</option>
						</select>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<button id="alertBox" style="margin-top: 9%;"
							class="btn btn-success">Search</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div id="map"
						style="width: 100%; height: 45%; background-color: black;"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div style="width: 100%; height: 45%;">
						<p id="resultMessage"></p>
					</div>
				</div>
			</div>
		</section>
	</div>
	<form id="homesubmit" action="forcast" method="post">
		<input type="hidden" name="hidden" value="adminhome">
	</form>
	<form id="viewmap" action="forcast" method="post">
		<input type="hidden" name="hidden" value="viewmap">
	</form>
	<form id="cimeprediction" action="forcast" method="post">
		<input type="hidden" name="hidden" value="cimeprediction">
	</form>
	<form id="adminregister" action="forcast" method="post">
		<input type="hidden" name="hidden" value="adminregister">
	</form>
	<form id="keralarecords" action="forcast" method="post">
		<input type="hidden" name="hidden" value="keralarecords">
	</form>
	<form id="caseregister" action="forcast" method="post">
		<input type="hidden" name="hidden" value="caseregister">
	</form>
	<form id="logout" action="forcast" method="post">
		<input type="hidden" name="hidden" value="logout">
	</form>
	<script src="dist/canvasjs.min.js"></script>
	<script src="plugins/jquery-2.2.3.min.js"></script>
	<script src="plugins/bootstrap.min.js"></script>
	<script src="plugins/fastclick.js"></script>
	<script src="plugins/app.min.js"></script>
	<script src="plugins/demo.js"></script>
</body>
<script type="text/javascript">
	function homeSubmit() {
		document.getElementById("homesubmit").submit();
	}
	function viewmap() {
		document.getElementById("viewmap").submit();
	}
	function cimeprediction() {
		document.getElementById("cimeprediction").submit();
	}
	function adminregister() {
		document.getElementById("adminregister").submit();
	}
	function caseregister() {
		document.getElementById("caseregister").submit();
	}
	function keralarecords() {
		document.getElementById("keralarecords").submit();
	}
	function logout() {
		document.getElementById("logout").submit();
	}
	function getAllDistrcitName() {
		var select = document.getElementById('districtnames');
		while (select.firstChild) {
			select.removeChild(select.firstChild);
		}
		var select = document.getElementById('statenames').value;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var sessionObject = this.responseText;
				var jsonObj = JSON.parse(sessionObject);
				var select = document.getElementById("districtnames");
				var length = select.options.length;
				var trannumber = document.getElementById("districtnames");
				var i = 0;
				var text = "";
				var option = document.createElement("option");
				option.text = "-select-"
				trannumber.add(option);
				for (i = 0; i < jsonObj.length; i++) {
					var option = document.createElement("option");
					option.text = jsonObj[i];
					trannumber.add(option);
				}
			}
		};
		xhttp.open("GET",
				"forcast?hidden=predictionHidden&methodName=getDistrict&stateName="
						+ select + "", true);
		xhttp.send();
	}
	function getAllPlaceName() {
		var select = document.getElementById('placenames');
		while (select.firstChild) {
			select.removeChild(select.firstChild);
		}
		var select = document.getElementById('districtnames').value;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var sessionObject = this.responseText;
				var jsonObj = JSON.parse(sessionObject);
				var select = document.getElementById("placenames");
				var length = select.options.length;
				var trannumber = document.getElementById("placenames");
				var i = 0;
				var text = "";
				var option = document.createElement("option");
				option.text = "-select-"
				trannumber.add(option);
				for (i = 0; i < jsonObj.length; i++) {
					var option = document.createElement("option");
					option.text = jsonObj[i];
					trannumber.add(option);
				}
			}
		};
		xhttp.open("GET",
				"forcast?hidden=predictionHidden&methodName=getPlaces&districtName="
						+ select + "", true);
		xhttp.send();
	}
	document.querySelector('#alertBox').onclick = function() {
		var place = document.getElementById("placenames").value;
		if (place == '-select-') {
			swal('Select any place :( ');
		} else {
			swal({
				title : 'Search Data About ' + place,
				text : 'Click Ok to submit',
				type : 'info',
				showCancelButton : true,
				closeOnConfirm : false,
				showLoaderOnConfirm : true,
			}, function() {
				setTimeout(function() {
					var result = showPredictionResult(place);
					swal('Request Received! ');
				}, 2000);
			});
		}
	};
	function showPredictionResult(place) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var sessionObject = this.responseText;
				var jsonObj = JSON.parse(sessionObject);

				var locationLabel = JSON.parse(jsonObj['cord']);
				var message = jsonObj['message'];
				document.getElementById("resultMessage").innerHTML = message;
				var place = jsonObj['place'];
				resultMap(place, locationLabel);
			}
		};
		xhttp.open("GET",
				"forcast?hidden=predictionHidden&methodName=predictionResult&placeName="
						+ place + "", true);
		xhttp.send();
	}
	function resultMap(place, locationLabel) {
		var map;
		var bounds = new google.maps.LatLngBounds();
		var mapOptions = {
			mapTypeId : 'roadmap',
		};

		// Display a map on the page
		map = new google.maps.Map(document.getElementById("map"), mapOptions);

		// Display multiple markers on a map
		var infoWindow = new google.maps.InfoWindow(), marker, i;

		// Loop through our array of markers & place each one on the map  
		for (i = 0; i < locationLabel.length; i++) {
			var icon = 'icons/' + locationLabel[i]['icon'] + '-26.png';
			var position = new google.maps.LatLng(locationLabel[i]['latitude'],
					locationLabel[i]['longitude']);
			bounds.extend(position);
			marker = new google.maps.Marker({
				position : position,
				map : map,
				icon : icon,
				title : locationLabel[i]['caseFullForm']
			});

			// Allow each marker to have an info window    
			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infoWindow.setContent(infoWindowContent[i][0]);
							infoWindow.open(map, marker);
						}
					})(marker, i));

			// Automatically center the map fitting all markers on the screen
			map.fitBounds(bounds);
		}

		// Override our map zoom level once our fitBounds function runs (Make sure it only runs once)
		var boundsListener = google.maps.event.addListener((map),
				'bounds_changed', function(event) {
					this.setZoom(16);
					google.maps.event.removeListener(boundsListener);
				});

	}
</script>
<script type="text/javascript">
	var jsonArryay = [];
	function viewdistrict() {
		var select = document.getElementById('districtname');
		while (select.firstChild) {
			select.removeChild(select.firstChild);
		}
		var name = document.getElementById('statenames').value;
		if (name == null || name == "") {
			alert('select value is empty');
		} else {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var sessionObject = this.responseText;
					var jsonObj = JSON.parse(sessionObject);
					var select = document.getElementById("districtname");
					var length = select.options.length;
					var trannumber = document.getElementById("districtname");
					var i = 0;
					var text = "";
					for (i = 0; i < jsonObj.length; i++) {
						var option = document.createElement("option");
						option.text = jsonObj[i];
						trannumber.add(option);
						jsonArryay.push(jsonObj[i]);
					}
				}
			};
			xhttp.open("GET", "forcast?statename=" + name
					+ "&hidden=getdistrictname", true);
			xhttp.send();
		}
	}

	var north = 9.529260;
	var east = 76.822881;

	function onplageLoad() {
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 7,
			center : {
				lat : north,
				lng : east
			}
		});
		var geocoder = new google.maps.Geocoder();

		document.getElementById('myclick').addEventListener(
				'click',
				function() {
					if (jsonArryay == "-select-") {
						alert('select state');
						return false;
					}
					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 5,
						center : {
							lat : north,
							lng : east
						}
					});
					geocodeAddress(geocoder, map, jsonArryay);
				});
	}
	var marker;
	function geocodeAddress(geocoder, resultsMap, places) {
		alert('hello');
		var i;
		for (i = 0; i < places.length; i++) {
			geocoder.geocode({
				'address' : places[i],
				componentRestrictions : {
					country : 'in',
				}
			}, function(results, status) {
				if (status === 'OK') {
					resultsMap.setCenter(results[0].geometry.location);

					var marker = new google.maps.Marker({
						map : resultsMap,
						position : results[0].geometry.location
					});
				} else {
				}
			});
		}
		jsonArryay = [];

	}

	function handleLocationError(browserHasGeolocation, infoWindow, pos) {
		infoWindow.setPosition(pos);
		infoWindow
				.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
						: 'Error: Your browser doesn\'t support geolocation.');
	}
</script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCkdWp6wd3GfMf-6FHOTyMIh5mnIE-bh3I&libraries=places&callback=initMap">
	
</script>
<script src="plugins/alert/sweetalert-dev.js"></script>
</html>