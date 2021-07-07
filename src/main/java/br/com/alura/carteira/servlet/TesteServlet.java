package br.com.alura.carteira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("nome");

		res.getWriter().println("<html>");
		res.getWriter().println("<body>");
		res.getWriter().println("<h1>");
		res.getWriter().println(nome);
		res.getWriter().println("</h1>");
		res.getWriter().println("</body>");
		res.getWriter().println("</html>");
	}

}