package edu.curso.controller;

import java.io.IOException;
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
			HttpServletResponse res) throws IOException { 
		String cmd = req.getParameter("cmd");
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
		String msg = null;
		if ("adicionar".equals(cmd)) { 
			incidentes.add(i);
			msg = "O incidente foi registrado com sucesso";
		} else if ("pesquisar".equals(cmd)) {
			List<Incidente> tempLista = new ArrayList<>();
			msg = "Nenhum incidente localizado";
			for (Incidente tempInci : incidentes) { 
				if (tempInci.getTitulo().contains(i.getTitulo())) { 
					tempLista.add(tempInci);
					msg = "Incidente localizado";
				}
			}
			req.getSession().setAttribute("LOCALIZADOS", tempLista);
		}
		
		req.getSession().setAttribute("MENSAGEM", msg);
		
		res.sendRedirect("./incidente.jsp");
	}
}
