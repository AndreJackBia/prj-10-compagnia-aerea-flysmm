<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="promotion.Promotion"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js"></script>

<title>FlySMM</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<a href="index.jsp" class="item">FlySMM</a>
		<a class="item">About Us </a>
		<a class="item"> Jobs </a>
		<a class="item"> Locations </a>
		<a href="registry.jsp" class="right item"> Sign up </a>
	</div>
	<table class="ui celled table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Discount Rate</th>
				<th>Fidelity</th>
				<th>Description</th>
				<th>Start Date</th>
				<th>Expire Date</th>
				<th>Flight</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${promotion}" var="promotion">
				<tr>
					<td>${promotion.name}</td>
					<td>${promotion.discountRate}</td>
					<td>${promotion.fidelity}</td>
					<td>${promotion.description}</td>
					<c:if test="${promotion.getClass() eq 'class promotion.SeasonPromotion'}">
						<td>${promotion.startDate}</td>
						<td>${promotion.expireDate}</td>
						<td></td>
					</c:if>
					<c:if test="${promotion.getClass() eq 'class promotion.FlightPromotion'}">
						<td></td>
						<td></td>
						<!-- I use New Flight() so promotion.flight = null -->
						<td>${promotion.flight.idFlight}</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>