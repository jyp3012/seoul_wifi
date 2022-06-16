<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "wifiServises.wifiService" %>
<%@ page import = "wifiServises.wifi_prameter" %>
<%@ page import = "wifiServises.wifiJSON" %>
<%@ page import = "java.net.*" %>
<%@ page import = "org.json.simple.*" %>
<%@ page import = "org.json.simple.parser.JSONParser" %>
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
	<h1 style = "text-align: center;" >
	<%
	Class.forName("org.sqlite.JDBC");
	List<wifi_prameter> arr = new ArrayList<>();
	wifiService wifi = new wifiService();
	wifiJSON wifiJosn = new wifiJSON();
	%>
	<% 
	wifi.insertWifi(wifiJosn.getWifiJson());
	String totalNum = wifi.totalWifi();
	%>
	<% 
	out.print(totalNum);
	%>
	
	개의 WIFI정보를 정상적으로 저장하였습니다.
	</h1>
	<div style = "text-align: center" >
	<a href = "index.jsp"> 홈으로 이동</a>
	</div>
	
	

</body>
</html>