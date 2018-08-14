package com.cyh.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyh.dao.FilmDao;
import com.cyh.dao.impl.FilmDaoImpl;
import com.cyh.modle.Film;

public class FilmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		FilmDao dao = new FilmDaoImpl();
		if("list".equals(method)){
			List<Film> list = dao.listFilm();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/film.jsp").forward(request, response);
		}else if("delete".equals(method)){
			String id = request.getParameter("id");
			dao.deleteFilm(id);
			response.sendRedirect(request.getContextPath()+"/film?method=list");
		}else if("edit".equals(method)){
			String film_id = request.getParameter("film_id");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String language = request.getParameter("language");
			Film film = new Film();
			film.setFilm_id(Integer.parseInt(film_id));
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguage(language);
			dao.edit(film);
			response.sendRedirect(request.getContextPath()+"/film?method=list");
		}else if("search".equals(method)){
			String film_id = request.getParameter("getItem");
			List<Film> list = dao.search(film_id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/film.jsp").forward(request, response);
		}else if("newFilm".equals(method)){
			String newTitle = request.getParameter("newTitle");
			String newDescription = request.getParameter("newDescription");
			String newLanguage = request.getParameter("newLanguage");
			dao.newItem(newTitle,newDescription,newLanguage);
			response.sendRedirect(request.getContextPath()+"/film?method=list");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
