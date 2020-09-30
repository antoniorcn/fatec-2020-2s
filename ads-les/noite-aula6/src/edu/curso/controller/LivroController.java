package edu.curso.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.curso.entidade.Livro;

@WebServlet("/livroController")
public class LivroController extends HttpServlet {
	
	public void doPost(	HttpServletRequest req, 
						HttpServletResponse res) throws IOException { 
		ServletContext app = req.getServletContext();
		List<Livro> livros = (List<Livro>)app.getAttribute("LIVROS");
		if (livros == null) { 
			livros = new ArrayList<>();
			app.setAttribute("LIVROS", livros);
		}
		
		Livro livro = new Livro();
		try { 
			livro.setTitulo( req.getParameter("txtTitulo") );
			livro.setAutor( req.getParameter("txtAutor") );
			livro.setGenero( req.getParameter("txtGenero") );
			livro.setEditora( req.getParameter("txtEditora") );
			livro.setPaginas( Integer.parseInt(req.getParameter("txtPaginas")) );
			livro.setId( Long.parseLong(req.getParameter("txtID")) );
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		livros.add(livro);
		String msg = String.format(
				"Livro adicionado com sucesso, há %d livros na lista", 
				livros.size());
		System.out.println(msg);
		
		HttpSession session = req.getSession();
		session.setAttribute("MENSAGEM", msg);
		
		res.sendRedirect("./livro.jsp");
	}

}
