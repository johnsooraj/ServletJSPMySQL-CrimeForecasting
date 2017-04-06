<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<link rel="icon" type="image/gif/png" href="contacts-xxl.png">
<title>Admin | Home</title>
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

<script type="text/javascript">
	var yy = [ 20, 50, 60, 20, 50, 60, 20, 50, 60, 20, 50, 60, ];
	window.onload = function() {
		var chart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "Number Of Crime Per Year"
			},
			axisX : {
				interval : 10
			},
			data : [ {
				type : "line",
				dataPoints : [ {
					x : new Date(2001, 01, 01),
					y : 62356
				}, {
					x : new Date(2002, 01, 01),
					y : 35635
				}, {
					x : new Date(2003, 01, 01),
					y : 34252
				}, {
					x : new Date(2004, 01, 01),
					y : 22524
				}, {
					x : new Date(2005, 01, 01),
					y : 73556
				}, {
					x : new Date(2006, 01, 01),
					y : 25426
				}, {
					x : new Date(2007, 01, 01),
					y : 63563
				}, {
					x : new Date(2008, 01, 01),
					y : 65447
				}, {
					x : new Date(2009, 01, 01),
					y : 23566
				}, {
					x : new Date(2010, 01, 01),
					y : 62356
				}, {
					x : new Date(2011, 01, 01),
					y : 34554
				}, {
					x : new Date(2012, 01, 01),
					y : 25566
				}, {
					x : new Date(2013, 01, 01),
					y : 33654
				}, {
					x : new Date(2014, 01, 01),
					y : 45433
				},

				]
			} ]
		});
		chart.render();
	}
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
</style>
<body>
	<div class="container">
		<h1>
			Welcome <small>Administrator</small>
		</h1>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">CrimeForcast</a>
				</div>
				<ul class="nav navbar-nav">

					<li role="presentation"  class="active"><a onclick="homeSubmit()">Home</a></li>
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
							<li><a href="#" onclick="adminregister()">Admin
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
			<h2>Administrator Home</h2>
		</section>
		<section class="content">
			<div class="col-md-12">
				<div class="row">
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-aqua">
							<div class="inner">
								<h3>${sessionScope.totalCases}</h3>
								<p>Total Case</p>
							</div>
							<div class="icon">
								<i class="ion ion-bag"></i>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<div class="small-box bg-green">
							<div class="inner">
								<h3>
									29+7<sup style="font-size: 20px">%</sup>
								</h3>
								<p>Total States</p>
							</div>
							<div class="icon">
								<i class="ion ion-stats-bars"></i>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<div class="small-box bg-yellow">
							<div class="inner">
								<h3>44</h3>
								<p>User Registrations</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-xs-6">
						<div class="small-box bg-red">
							<div class="inner">
								<h3>65</h3>
								<p>Unique Visitors</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div id="chartContainer" style="height: 400px; width: 100%;"></div>
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
	<script src="dist/jquery.canvasjs.min.js"></script>
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