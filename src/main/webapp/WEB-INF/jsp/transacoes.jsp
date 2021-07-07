<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Transacoes</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Lista de Transacoes</h1>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>TICKER</th>
					<th>PRECO</th>
					<th>QUANTIDADE</th>
					<th>DATA</th>
					<th>TIPO</th>
			</thead>
			<tbody>
				<c:forEach var="transacao" items="${transacoes}">
					<tr>
						<td>${transacao.ticker}</td>
						<td>${transacao.preco}</td>
						<td>${transacao.quantidade}</td>
						<td>${transacao.data}</td>
						<td>${transacao.tipo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
