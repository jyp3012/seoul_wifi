<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wifiServises.wifiService"%>
<%@ page import="wifiServises.wifi_prameter"%>
<%@ page import="wifiServises.wifiJSON"%>
<%@ page import="java.net.*"%>
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
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String Lat = request.getParameter("lat");
	String Lng = request.getParameter("lng");
	
	%>
	<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Class.forName("org.sqlite.JDBC");
	String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
	con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);

	final String sql = "INSERT into gps_hstiory (" + " lat, lng) " + " values ( " + " ?, " + " ?  " + " ); ";
	try {
		//prepareStatement 생성
		pstmt = con.prepareStatement(sql);

		pstmt.setObject(1, Lat);
		pstmt.setObject(2, Lng);

		//쿼리 실행
		pstmt.executeUpdate();
		
		
		con.close();
	} catch (SQLException e) {
		System.out.println(e.getMessage());

		if (con != null) {
			con.rollback();
		}

	} finally {
		if (pstmt != null) {
			try {
		pstmt.close();
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
	}
	
	//홈으로 귀환
	response.sendRedirect("index.jsp");
	%>

</body>
</html>