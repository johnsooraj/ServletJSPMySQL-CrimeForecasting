<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<link rel="icon" type="image/gif/png" href="contacts-xxl.png">
<title>New Case Register</title>
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

#sectionSelector {
	margin-right: 10%;
	font-size: 20px;
	font-family: cursive;
	color: white;
}
</style>
<body>
	<div class="container">
		<h1>
			Register <small>new cases</small>
		</h1>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">CrimeForcast</a>
				</div>
				<ul class="nav navbar-nav">

					<li role="presentation"><a onclick="homeSubmit()">Home</a></li>
					<li role="presentation"><a onclick="cimeprediction()">Crime
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
							<li class="active"><a href="#" onclick="caseregister()">Case
									Registration</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" onclick="logout()"><span
							class="fa fa-fw fa-unlock"></span> Log out</a></li>
				</ul>
			</div>
		</nav>
		<form action="/prediction/forcast" method="post">
			<section class="content">
				<input type="hidden" name="hidden" value="localCaseRegister">
				<div id="section1" class="container-fluid">
					<div class="row">
						<div class="col-sm-3 form-group">
							<label>State</label> <select id="selectbasic" name="state"
								required="required" class="form-control input-md">
								<option>Kerala</option>
								<option>Tamil Nadu</option>
							</select>
						</div>
						<div class="col-sm-3 form-group">
							<label>District</label> <input type="text" required="required"
								placeholder="Enter district.." name="district"
								class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Place</label> <input type="text" required="required"
								placeholder="Enter Place.." name="place" class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Nearest Police Station</label> <input type="text"
								required="required" placeholder="Enter nearestPoliceStation.."
								name="nearestPoliceStation" class="form-control">
						</div>
					</div>
				</div>
				<div id="section2" class="container-fluid">
					<div class="row">
						<div class="col-sm-3 form-group">
							<label>Crime Date</label> <input type="text" required="required"
								placeholder="Enter crimeDate(dd/mm/yyyy).." name="crimeDate"
								class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Longitude</label> <input type="text" required="required"
								placeholder="Enter longitude.." name="longitude"
								class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Latitude</label> <input type="text" required="required"
								placeholder="Enter Latitude.." name="latitude"
								class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Type Of Crime</label> <input type="text"
								required="required" placeholder="Enter typeOf_Crime"
								name="typeOf_Crime" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3 form-group">
							<label style="color: black;">Crime Time</label> <input
								type="text" required="required"
								placeholder="Enter crime time(hh/mm/ss).." name="crime_time"
								class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label style="color: black;">Victim Gender</label> <select
								id="selectbasic" name="victimGender" required="required"
								class="form-control input-md">
								<option>male</option>
								<option>female</option>
							</select>
						</div>
						<div class="col-sm-3 form-group">
							<label style="color: black;">Victim Age</label> <input
								type="text" required="required" placeholder="Enter victimAge.."
								value="00" name="victimAge" class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label style="color: black;">Any Vitness</label> <input
								type="text" required="required"
								placeholder="Enter anyVitness (yes/no).." value="no"
								name="anyVitness" class="form-control">
						</div>
					</div>
				</div>
				<div id="section3" class="container-fluid">
					<div class="row">
						<div class="col-sm-3 form-group">
							<label>Vitness Age</label> <input type="text" required="required"
								placeholder="Enter vitnessAge (if no Put 00).." value="00"
								name="vitnessAge" class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Any Suspect</label> <input type="text" required="required"
								placeholder="Enter anySuspect (yes/no).." value="no"
								name="anySuspect" class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Suspect Age</label> <input type="text" required="required"
								placeholder="Enter suspectAge..(if no Put 00)" value="00"
								name="suspectAge" class="form-control">
						</div>
						<div class="col-sm-3 form-group">
							<label>Suspect Gender</label> <select id="selectbasic"
								name="suspectGender" required="required"
								class="form-control input-md">
								<option>male</option>
								<option>female</option>
							</select>
						</div>
						<div class="col-sm-3 form-group">
							<label>Location Type</label> <select id="selectbasic"
								name="locationType" required="required"
								class="form-control input-md">
								<option>city</option>
								<option>rural</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3 form-group">
							<label>Register New Crime</label> <input type="submit"
								name="Register" value="Register" class="btn btn-success">
						</div>
					</div>
				</div>
			</section>
		</form>
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
</script>
</html>