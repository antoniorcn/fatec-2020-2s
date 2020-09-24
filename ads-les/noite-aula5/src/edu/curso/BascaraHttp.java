package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bhaskara")
public class BascaraHttp extends HttpServlet {
	
	public void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException { 
		String msg = "";
		try { 
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			int c = Integer.parseInt(req.getParameter("c"));
			float delta = b * b -4 * a * c;
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
			double x2 = (-b - Math.sqrt(delta)) / (2 * a);
			if (delta < 0) { 
				msg = "Não há raizes reais para estes valores";
			} else { 
				msg = String.format("Raizes X1: %6.2f   X2: %6.2f%n", x1, x2);
			}
		} catch (Exception e) { 
			e.printStackTrace();
			msg = "Erro ao calcular a equação";
		}
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Bhaskara</h1>");
		out.println("<h4>" + msg +" </h4>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

}
