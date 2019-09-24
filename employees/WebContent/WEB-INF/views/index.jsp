<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<h1>Index</h1>
	<h2>테이블 정보</h2>
	<div>
		<table class="table table-hover">
			<thead class="table-secondary">
				<tr>
					<th>테이블 이름</th>
					<th>전체 행의 수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>departments</td>
					<td>${departmentsRowCount }</td>
				</tr>
				<tr>
					<td>employees</td>
					<td>${employeesRowCount}</td>
				</tr>
				<tr>
					<td>dept_manager</td>
					<td>${deptManagerRowCount }</td>
				</tr>
				<tr>
					<td>dept_emp</td>
					<td>${deptEmpRowCount }</td>
				</tr>
				<tr>
					<td>titles</td>
					<td>${titlesRowCount }</td>
				</tr>
				<tr>
					<td>salaries</td>
					<td>${salariesRowCount }</td>
				</tr>
			</tbody>
		</table>
	</div>
		<a href="${pageContext.request.contextPath}/departments/getDepartmentsList" class="btn btn-outline-primary">부서 목록</a>
		<a href="${pageContext.request.contextPath}/employees/getEmployeesList" class="btn btn-outline-primary">사원 목록</a>
		<div>
			사원목록 :
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc" class="btn btn-outline-warning">오름차순50개</a>
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc" class="btn btn-outline-warning">내림차순50개</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무 목록(중복제거 distinct)</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">salary 연봉 통계값(count, sum, avg, max, min, std)</a>
		</div>
</body>
</html>