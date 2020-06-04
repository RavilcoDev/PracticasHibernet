package com.rafael.hibernet.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rafael.hibernet.DAO.CursoDAO;
import com.rafael.hibernet.Interface.ICursoDAO;
import com.rafael.hibernet.Modelo.Curso;

/**
 * Servlet implementation class CursoServlet
 */
@WebServlet(name = "CursoServlet", urlPatterns = { "/CursoServlet" })
public class CursoServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet ListaAlumnoServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet ListaAlumnoServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opc = request.getParameter("operation");

		if (opc.equals("listar")) {
			listaCursos(request, response);
		} else if (opc.equals("crear")) {
			crearCursos(request, response);
		} else if (opc.equals("buscar")) {
			buscarCursos(request, response);
		} else if (opc.equals("modificar")) {
			modificarCursos(request, response);
		}

	}

	private void crearCursos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Curso curso = new Curso();
		curso.setNombre(request.getParameter("txtNombre"));
		curso.setDocente(request.getParameter("txtLugar"));
		curso.setLugar(request.getParameter("txtDocente"));
		System.err.print(curso.toString());
		ICursoDAO manager = new CursoDAO();

		boolean res = manager.create(curso);
		
		System.out.println(res);
		if (res) {
			request.setAttribute("mens", "exxito.");
			listaCursos(request, response);
		} else {
			request.setAttribute("mens", "error: no se creo.");
			request.getRequestDispatcher("/listaCursos.jsp").forward(request, response);
		}

	}

	private void modificarCursos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub

	}

	private void buscarCursos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub

	}

	private void listaCursos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ICursoDAO manager = new CursoDAO();
		List<Curso> data = manager.findAll();
		request.setAttribute("cursos", data);
		if((String)request.getAttribute("mens") == null)
			request.setAttribute("mens", "");
		request.getRequestDispatcher("/listaCursos.jsp").forward(request, response);

	}

}
