<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<link rel="icon" type="image/gif/png" href="contacts-xxl.png">
<title>Kerala</title>
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
	background-repeat: no-repeat;
	background-attachment: fixed;
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
			Welcome <small>to kerala crime records</small>
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
							<li  class="active"><a href="#" onclick="keralarecords()">View Kerala
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
		<section class="content">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Registered Kerala Crime Report</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
							<c:set var="count" value="1" scope="page" />
							<c:forEach var="record" items="${sessionScope.keralaRecord}">
								<tr>
									<td><input type="checkbox"></td>
									<td><span class="pull-right-container"> <small
											class="label bg-yellow"><c:out value="${count}"></c:out></small>
									</span></td>
									<td class="mailbox-subject"><b><c:out
												value="${record.place}"></c:out> </b></td>
									<td class="mailbox-subject"><b><c:out
												value="${record.crimeDate}"></c:out> </b></td>
									<td class="mailbox-subject"><b><c:out
												value="${record.typeOf_Crime}"></c:out> </b></td>
									<td class="mailbox-subject"><b><a><c:out
													value="${record.nearestPoliceStation}"></c:out></a> </b></td>
								</tr>
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table -->
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
</script>
</html>