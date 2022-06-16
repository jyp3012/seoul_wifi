<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

#wifiprameter tr:nth-child(even){background-color: #f2f2f2;}

#wifiprameter tr:hover {background-color: #ddd;}

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
<h1>서울시 공용 와이파이 정보 구하기</h1>
<a href = "index.jsp">홈</a> <a>위치 히스토리 목록</a> <a href = "wifiListUp.jsp">OPEN API 와이파이 정보 가져오기</a>

<p> LAT </p>
<div style="border: 1px solid black; padding: 10px; width: 150px" ></div>

<p> LNT </p>
<div style="border: 1px solid black; padding: 10px; width: 150px" ></div>

<table id="wifiprameter">
  <tr>
    <th>거리(km)</th>
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
  	<td colspan = '17'>위치 정보를 입력한 후에 조회해 주세요.</td>
  </tr>
</table>

</body>
</html>