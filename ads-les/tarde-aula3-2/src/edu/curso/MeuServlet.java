package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/meuservlet")
public class MeuServlet implements Servlet {
	private ServletConfig config;
	
	public MeuServlet() { 
		System.out.println("Construtor Executado...");
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return MeuServlet.class.getName();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Init do Servlet Executado...");
	}

	@Override
	public void service(ServletRequest request, 
			ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("O Servlet foi acionado...");
		out.println("<h1>Ola navegador bem vindo ao servlet da Aula 3</h1>");
		out.flush();
	}

}
