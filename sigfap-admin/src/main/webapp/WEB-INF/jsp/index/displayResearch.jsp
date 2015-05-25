<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sigfap | Exibir Pesquisadores</title>
</head>
<body>
	<table id="datatable_fixed_column"
		class="table table-striped table-bordered" width="100%" align="center">

		<thead>
			<tr>
				<th class="hasinput" style="width: 17%"><input type="text"
					class="form-control" placeholder="Filter Name" /></th>

				<th class="hasinput" style="width: 16%"><input type="text"
					class="form-control" placeholder="Filter Office" /></th>
				<th class="hasinput" style="width: 17%"><input type="text"
					class="form-control" placeholder="Filter Login" /></th>
				<th class="hasinput icon-addon"><input id="dateselect_filter"
					type="text" placeholder="Filter Date"
					class="form-control datepicker" data-dateformat="dd/mm/yy">
					<label for="dateselect_filter"
					class="glyphicon glyphicon-calendar no-margin padding-top-15"
					rel="tooltip" title="" data-original-title="Filter Date"></label></th>

			</tr>
			<tr>
				<th data-class="expand">Nome</th>

				<th data-class="expand">Curso</th>
				
				<th data-class="expand">Tipo</th>
				
				<th data-class="expand">E-mail</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="busca" items="${busca}">
				<tr>
					<td>${busca.nome}</td>
					<td>${busca.curso}</td>
					<td>${busca.tipo}</td>
					<td>${busca.email}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>