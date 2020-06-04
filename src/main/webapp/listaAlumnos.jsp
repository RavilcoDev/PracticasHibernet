<%@page import="com.rafael.hibernet.Modelo.TbAlumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ListaAlumnoServlet" name="frmConsulta" method="post">
		<input type="hidden" name="operation" value="listar"> <label
			class="login">Consular alumnos </label> 
			<input class="login"
			type="radio" name="rbtTipo" value="porNombres" checked>
		Filtrar por nombres 
		<input class="login" type="radio" name="rbtTipo"
			value="porApellidos" > Filtrar por apellidos <label
			class="login">Ingrese tecto: </label> <input class="login"
			type="text" name="txtCadena"> <br> <input
			class="loginBUtton" type="submit" value="enviar">
	</form>
	<table>
		<tr class="grilla_cabecera">
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
		</tr>
		<!-- 
                           Scriplet: son inserciones de codigo java dentro un JSP    < % %>
                           Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>    
              -->
		<%
			List<TbAlumno> a = (List<TbAlumno>) request.getAttribute("alumnos");
		if (a != null) {
			for (TbAlumno aux : a) {
		%>
		<tr class="grilla_campo">
			<td><%=aux.getIdtbAlumno()%></td>
			<td><%=aux.getNombre()%></td>
			<td><%=aux.getApellido()%></td>
			<td><%=aux.getEdad()%></td>
			<td><a
				href="ListaAlumnoServlet?operaration=listar&id=<%=aux.getIdtbAlumno()%>">
					<img alt="modificar" src="images/Edit.gif">
			</a></td>
		</tr>

		<%}
}%>

	</table>
</body>
</html>