package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/principal")
public class MeuServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, 
			ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<h1>bem vindo ao servlet Generic da aula 4</h1>");
		out.flush();
		
	}

}
