<%@page import="com.rafael.hibernet.Modelo.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container mx-auto">

		<br>
		<p class="text-base">Crear</p>

		<form action="CursoServlet" name="frmConsulta" method="post"
			class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
			<input type="hidden" name="operation" value="crear">

			<div class="flex flex-wrap -mx-3 mb-2">

				<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">

					<input type="hidden" name="operation" value="listar"> 
					
					<label class="login">Nombre: </label> 
					<input class="bg-gray-200 py-3 px-4 pr-8" type="text" name="txtNombre"> <br> <br>
					
					<label class="login">Lugar: </label> 
					<input class="bg-gray-200 py-3 px-4 pr-8" type="text" name="txtLugar"> <br> <br>
				</div>

				<div class="w-full md:w-1/2 px-3">

					Docente
					<div class="relative">
						<select
							class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
							id="grid-state"
							name="txtDocente">
							<option value="Juan Zerico">Juan Zerico</option>
							<option value="Raul Francisco">Raul Francisco</option>
							<option value="Veronica Texas">Veronica Texas</option>
						</select>

					</div>

				</div>
			</div>

			<input
				class="bg-green-300 hover:bg-gray-400 text-gray-800 font-bold py-2 px-4 rounded inline-flex items-center"
				type="submit" value="enviar">
		</form>
	<br>
		<a href="CursoServlet?operation=listar">
					<img alt="modificar" src="images/Edit.gif">
		</a>
		<% String mensaje = (String)request.getAttribute("mens"); %>
		<h1> <%=mensaje%></h1>
	<br>
		<table class="table-fixed">
			<tr class="grilla_cabecera">
				<th class="px-4 py-2">Id</th>
				<th class="px-4 py-2">Nombre</th>
				<th class="px-4 py-2">Docente</th>
				<th class="px-4 py-2">Lugar</th>
				<th class="px-4 py-2">Modificar</th>
			</tr>
			<!-- 
                           Scriplet: son inserciones de codigo java dentro un JSP    < % %>
                           Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>    
              -->
			<%
				List<Curso> c = (List<Curso>) request.getAttribute("cursos");
			if (c != null) {
				for (Curso aux : c) {
			%>
			<tr class="grilla_campo">
				<td class="border px-4 py-2"><%=aux.getIdCurso()%></td>
				<td class="border px-4 py-2"><%=aux.getNombre()%></td>
				<td class="border px-4 py-2"><%=aux.getDocente()%></td>
				<td class="border px-4 py-2"><%=aux.getLugar()%></td>
				<td class="border px-4 py-2"><a
					href="ListaAlumnoServlet?operaration=listar&id=<%=aux.getIdCurso()%>">
						<img alt="modificar" src="images/Edit.gif">
				</a></td>
			</tr>

			<%}
}%>

		</table>
	</div>

</body>
</html>