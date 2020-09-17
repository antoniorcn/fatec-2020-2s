package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/TabuadaG")
public class TabuadaGeneric extends GenericServlet{
	@Override
	public void service(ServletRequest req, 
			ServletResponse res) throws ServletException, IOException {
		
		//       NUMERO=9
		
		String strNumero = req.getParameter("NUMERO");
		
		int numero = 7;
		
		try { 
			numero = Integer.parseInt(strNumero);
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<h2>Tabuada Generic Servlet</h2>");
		for (int i = 0; i <= 10; i++) { 
			int resultado = i * numero;
			out.printf("<p>%d X %d = %d</p>%n", numero, i, resultado);
		}
		out.flush();		
	}
}
