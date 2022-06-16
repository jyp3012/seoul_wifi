<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src = "./js/jquery-3.5.1.js"></script>
<script type = "text/javascript" src = "./js/wifiListUp.js"></script>
<script></script>
</head>
<body>
	<form action = "wifilist.do" method = "post">
		<input type = "submit" value = "wifi 목록 업데이트">
		<input type = "hidden" name = "commond" value = "wifidb">
		<table border ="1">
			<thead>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
</body>
</html>