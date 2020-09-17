package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/IMC")
public class IMC extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		String strPeso = req.getParameter("PESO");
		String strAltura = req.getParameter("ALTURA");
		int peso = 0;
		int altura = 0;
		String mensagem = "";
		try { 
			peso = Integer.parseInt(strPeso);
			altura = Integer.parseInt(strAltura);
			double imc = (double)peso / (Math.pow((double)altura / 100.0, 2));
			mensagem = String.format("<p>Seu IMC é: %6.2f</p>%n", imc);
		} catch (Exception e) {
			mensagem = "<p>Erro ao calcular o IMC por favor informe os valores corretos</p>";	
		}
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h2>Servlet para calculo do IMC</h2>");
		out.println(mensagem);
		out.flush();
	}
}
