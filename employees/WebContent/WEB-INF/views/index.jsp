<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index</h1>
		<a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a>
		<a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a>
	<div>
		employees table total row count : <%=request.getAttribute("employeesRowCount") %>
	</div>
</body>
</html>