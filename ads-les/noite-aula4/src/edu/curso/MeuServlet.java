package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/MeuServlet")
public class MeuServlet implements Servlet {

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void service(ServletRequest req, 
			ServletResponse res) 
					throws ServletException, IOException {
		System.out.println("Ola o servlet foi acionado...");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h2 style=\"color:red;\">Ola navegador bem "
				+ "vindo ao MeuServlet</h2>");
		
		out.flush();
	}
}
