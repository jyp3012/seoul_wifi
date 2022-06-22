<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wifiServises.wifiService"%>
<%@ page import="wifiServises.wifi_prameter"%>
<%@ page import="wifiServises.wifiJSON"%>
<%@ page import="java.net.*"%>
<%@ page import="wifiServises.gps_parameter"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="org.json.simple.parser.JSONParser"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위치 히스토리</title>
</head>
<style>
#wifiprameter {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#wifiprameter th {
	border: 1px solid #ddd;
	padding: 8px;
	marigin: auto;
	text-align: center;
}

#wifiprameter td {
	border: 1px solid #ddd;
	padding: 30px;
	marigin: auto;
	text-align: center;
}

#wifiprameter tr:nth-child(even) {
	background-color: #f2f2f2;
}

#wifiprameter tr:hover {
	background-color: #ddd;
}

#wifiprameter th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #2ECCFA;
	color: white
}
</style>
<body>
	<%
List<gps_parameter> gpsList = new ArrayList<>();
wifiService wifi = new wifiService();
gpsList = wifi.listUpGps();
%>
	<h1>위치 히스토리</h1>

	<a href="index.jsp">홈으로 이동</a>

	<table id="wifiprameter">
		<tr>
			<th>경도</th>

			<th>위도</th>

		</tr>
		<tr>
		<%for (gps_parameter gps : gpsList) { %>
			<td>
				<%=
				gps.getLat()
				%>
			</td>
			<td>
				<%=
				gps.getLng()
				%>
			</td>
		</tr>
		<%
		}
		%>
		<%
		gpsList.clear();
		%>
	</table>


</body>
</html>