package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tabuada")
public class Tabuada extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException { 
		String strNumero = req.getParameter("NUMERO");
		int numero = 7;
		try { 
			numero = Integer.parseInt(strNumero);
		} catch (Exception e) { 
			// ignora
		}
		PrintWriter out = res.getWriter();
		
		for (int i = 0; i <= 10; i++) { 
			int resultado = numero * i;
			out.printf("<p> %d X %d = %d</p>%n", numero, i, resultado);
		}
		out.flush();		
	}
}
