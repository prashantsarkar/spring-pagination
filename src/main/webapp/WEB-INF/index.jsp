<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/resources/css/style.css" var="style" />
<spring:url value="/phones/all" var="pageurl" />
<link href="${style}" rel="stylesheet" />
</head>
<body>
	<div>
		<p>Welcome to Phones Store</p>
		<p>List of the Phones in our store.</p>
	</div>
	<div>
		<c:set var="pageListHolder" value="${phonesList}" scope="session" />
		<table cellspacing="0">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ph" items="${pageListHolder.pageList}">
					<tr>
						<td>${ph.id}</td>
						<td>${ph.name}</td>
						<td>&#8377; ${ph.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<span style="float: left;"> <c:choose>
				<c:when test="${pageListHolder.firstPage}">Prev</c:when>
				<c:otherwise>
					<a href="${pageurl}/prev">Prev</a>
				</c:otherwise>
			</c:choose>
		</span>
		<span> 
			<c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
    			&nbsp;&nbsp;
    			<c:choose>
					<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
					<c:otherwise>
						<a href="${pageurl}/${loop.index}">${loop.index+1}</a>
					</c:otherwise>
				</c:choose>
    			&nbsp;&nbsp;
    		</c:forEach>
		</span>
		<span>
			<c:choose>
				<c:when test="${pageListHolder.lastPage}">Next</c:when>
				<c:otherwise>
					<a href="${pageurl}/next">Next</a>
				</c:otherwise>
			</c:choose>
		</span>
	</div>
</body>
</html>