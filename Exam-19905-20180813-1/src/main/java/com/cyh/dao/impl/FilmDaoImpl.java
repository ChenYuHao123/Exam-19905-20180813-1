package com.cyh.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyh.dao.BaseDao;
import com.cyh.dao.FilmDao;
import com.cyh.modle.Film;
import com.cyh.util.StringUtil;

public class FilmDaoImpl extends BaseDao implements FilmDao {

	public List<Film> listFilm() {
		List<Film> list = new ArrayList<Film>();
		String sql = "select f.film_id,f.title,f.description,l.name from film f,language l where f.language_id = l.language_id";
		try {
			PreparedStatement prstmt = con.prepareStatement(sql);
			ResultSet rs = prstmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilm_id(rs.getInt("f.film_id"));
				film.setTitle(rs.getString("f.title"));
				film.setDescription(rs.getString("f.description"));
				film.setLanguage(rs.getString("l.name"));
				list.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public void deleteFilm(String id) {
		
		String prepare = "SET FOREIGN_KEY_CHECKS=0;";
		try {
			PreparedStatement p1 = con.prepareStatement(prepare);
			p1.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String sql = "delete from film where film_id = ?";
		PreparedStatement prstmt;
		try {
			prstmt = con.prepareStatement(sql);
			prstmt.setInt(1, Integer.parseInt(id));
			prstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String after = "SET FOREIGN_KEY_CHECKS=1;";
		try {
			PreparedStatement p2 = con.prepareStatement(prepare);
			p2.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	public void edit(Film film) {
		String prepare = "SET FOREIGN_KEY_CHECKS=0;";
		try {
			PreparedStatement p1 = con.prepareStatement(prepare);
			p1.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String sql = "update film set title = ?,description = ? where film_id = ? ";
		try {
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, film.getTitle());
			prstmt.setString(2, film.getDescription());
			prstmt.setInt(3, film.getFilm_id());
			prstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String after = "SET FOREIGN_KEY_CHECKS=1;";
		try {
			PreparedStatement p2 = con.prepareStatement(prepare);
			p2.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	public List<Film> search(String film_id) {
		List<Film> list = new ArrayList<Film>();
		if(!StringUtil.isEmpty(film_id)){
			String sql = "select f.film_id,f.title,f.description,l.name from film f,language l where f.language_id = l.language_id and f.film_id = ?";
			Film film = new Film();
			try {
				PreparedStatement prstmt = con.prepareStatement(sql);
				prstmt.setInt(1, Integer.parseInt(film_id));
				ResultSet rs = prstmt.executeQuery();
				if(rs.next()){
					film.setFilm_id(Integer.parseInt(film_id));
					film.setTitle(rs.getString("title"));
					film.setDescription(rs.getString("description"));
					film.setLanguage(rs.getString("l.name"));
					list.add(film);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			list = listFilm();
		}
		return list;
	}


	public void newItem(String newTitle, String newDescription, String newLanguage) {
		String sql_l = "select language_id from language where name = ?";
		int id = 0;
		try {
			PreparedStatement prstmt1 = con.prepareStatement(sql_l);
			prstmt1.setString(1, newLanguage);
			ResultSet rs1 = prstmt1.executeQuery();
			if(rs1.next()){
				id = rs1.getInt("language_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into film(title,description,language_id) values(?,?,?)";
		try {
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, newTitle);
			prstmt.setString(2, newDescription);
			prstmt.setInt(3, id);
			prstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

