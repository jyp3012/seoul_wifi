<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "wifiServises.wifiService" %>
<%@ page import = "wifiServises.wifi_prameter" %>
<%@ page import = "wifiServises.wifiJSON" %>
<%@ page import = "java.net.*" %>
<%@ page import = "org.json.simple.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
	<%
	wifiService wifi = new wifiService();
	wifiJSON wifiJSON = new wifiJSON();
	
	int a = wifi.insertWifi(wifiJSON.getWifiJson());

	%>
	개의 WIFI정보를 정상적으로 저장하였습니다.
	</h1>
	<div>
	<a href = "indx.jsp"> 홈으로 이</a>
	</div>
	
	

</body>
</html>