package edu.curso.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.curso.entidade.Incidente;

@WebServlet("/incidenteController")
public class IncidenteController extends HttpServlet {
//	private List<Incidente> incidentes = new ArrayList<>();

	@Override
	public void doGet(HttpServletRequest req,
			HttpServletResponse res) { 
		
		ServletContext app = getServletContext();
		List<Incidente> incidentes = (List<Incidente>)app.getAttribute("LISTA");
		if (incidentes == null) { 
			incidentes = new ArrayList<>();
			app.setAttribute("LISTA", incidentes);
		}
				
		Incidente i = new Incidente();	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		try { 
			i.setTitulo(req.getParameter("txtTitulo"));
			i.setDescricao(req.getParameter("txtDescricao"));
			i.setStatus(req.getParameter("txtStatus"));
			i.setCategoria(req.getParameter("txtCategoria"));
			i.setId(Long.parseLong(req.getParameter("txtID")));
			i.setAbertura(LocalDateTime.parse(req.getParameter("txtDataAbertura") + " 00:00", formatter));
			i.setFechamento(LocalDateTime.parse(req.getParameter("txtDataFechamento") + " 00:00", formatter));
		} catch(Exception e) { 
			e.printStackTrace();
		}

		incidentes.add(i);
		System.out.printf("Lista de incidentes possui %d itens%n", incidentes.size());
	}
}
