<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div>
		목록 종류 :
		<a href="${pageContext.request.contextPath}/departments/getDepartmentsList" class="btn btn-outline-primary">부서 목록</a>
		<a href="${pageContext.request.contextPath}/employees/getEmployeesList" class="btn btn-outline-primary">사원 목록</a>
	</div>	
	<div>
		사원 목록 :
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc" class="btn btn-outline-warning">오름차순50개</a>
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc" class="btn btn-outline-warning">내림차순50개</a>
	</div>
	<br>
	<h2>목록 리스트</h2>
	<div class="list-group">
		<div>
			<a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct" class="list-group-item list-group-item-action">업무 목록(중복제거 distinct)</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics" class="list-group-item list-group-item-action">salary 연봉 통계값(count, sum, avg, max, min, std)</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender" class="list-group-item list-group-item-action">사원 수(성별 group by gender)</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo" class="list-group-item list-group-item-action">현재 부서별 사원수</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage" class="list-group-item list-group-item-action">사원목록 페이징(10명씩)</a>
		</div>
	</div>
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<div>
				<input type="number" name="begin">~<input type="number" name="end">${min}~${max}
				<button type="submit" class="btn btn-success">사원목록 between</button>
			</div>
		</form>
</body>
</html>