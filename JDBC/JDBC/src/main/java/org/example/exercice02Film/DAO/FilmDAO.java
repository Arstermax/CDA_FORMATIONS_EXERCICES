package org.example.exercice02Film.DAO;

import org.example.exercice02Film.entity.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String request;
    private List<Film> films = new ArrayList<>();

    private ResultSet resultSet;

    public FilmDAO(Connection connection) {
        this.connection = connection;
    }

    public Boolean createFilm(String titre, String realisateur, String genre) throws SQLException {
        request = """
                INSERT INTO films (titre,realisateur,genre) 
                VALUE (?,?,?)
                """;
        preparedStatement = this.connection.prepareStatement(request);
        preparedStatement.setString(1, titre);
        preparedStatement.setString(2, realisateur);
        preparedStatement.setString(3, genre);

        return preparedStatement.executeUpdate()> 0;
    }



    public Film updateTitle(String titre, int id) throws SQLException {
        Film films;
        request = "Update films set titre = ? where id = ?";
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, titre);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
    }

    public List<Film> getAllFilm() throws SQLException {
        films = new ArrayList<>();
        request = "SELECT * from films";
        preparedStatement = connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            films.add(Film.builder()
                    .id(resultSet.getInt("id"))
                    .titre(resultSet.getString("titre"))
                    .realisateur(resultSet.getString("realisateur"))
                    .genre(resultSet.getString("genre"))
                    .build());
        }
        return films;
    }
}
