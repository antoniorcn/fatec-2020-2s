package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Tabuada")
public class Tabuada implements Servlet {
	private ServletConfig config;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return Tabuada.class.getName();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int numero = 7;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		for (int i = 0; i <= 10; i++) { 
			int resultado = i * numero;
			out.printf("<p>%d X %d = %d</p>%n", numero, i, resultado);
		}
		out.flush();
	}

}
