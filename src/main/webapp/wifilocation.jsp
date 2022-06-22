<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wifiServises.wifiService"%>
<%@ page import="wifiServises.wifi_prameter"%>
<%@ page import="wifiServises.wifiJSON"%>
<%@ page import="wifiServises.gps_parameter" %>
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
<title>서울시 공용 와이파이 정보 구하기</title>
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
</head>
<body>
<%
	Class.forName("org.sqlite.JDBC");
	List<wifi_prameter> arr = new ArrayList<>();
	List<wifi_prameter> locatArr = new ArrayList<>();
	wifiService wifi = new wifiService();
	arr = wifi.findPlace();
	wifi.insertWifiLocat(arr);
	%>
	<%
	locatArr = wifi.selectWifiLocat();
	
	%>

	<h1>가까운 와이파이</h1>
	<a href="index.jsp">홈으로 이동</a>

	<p></p>

	<p></p>
	<table id="wifiprameter">
		<tr>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>wifi접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<tr>
		<tr>
		<%for (wifi_prameter wifilocat : locatArr) { %>
			<td>
				<%=
				wifilocat.getX_SWIFI_MGR_NO()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_WRDOFC()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_MAIN_NM()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_ADRES1()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_ADRES2()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_INSTL_FLOOR()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_INSTL_TY()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_INSTL_MBY()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_SVC_SE()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_CMCWR()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_CNSTC_YEAR()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_INOUT_DOOR()
				%>
			</td>
			<td>
				<%=
				wifilocat.getX_SWIFI_REMARS3()
				%>
			</td>
			<td>
				<%=
				wifilocat.getLAT()
				%>
			</td>
			<td>
				<%=
				wifilocat.getLNT()
				%>
			</td>
			<td>
				<%=
				wifilocat.getWORK_DTTM()
				%>
			</td>
			
			
		</tr>
		<%
		}
		%>
		
		</tr>
	</table>

</body>
</html>