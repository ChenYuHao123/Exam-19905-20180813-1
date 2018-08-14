package com.cyh.dao;

import java.util.List;

import com.cyh.modle.Film;

public interface FilmDao {

	List<Film> listFilm();

	void deleteFilm(String id);

	void edit(Film film);

	List<Film> search(String film_id);

	void newItem(String newTitle, String newDescription, String newLanguage);

}
