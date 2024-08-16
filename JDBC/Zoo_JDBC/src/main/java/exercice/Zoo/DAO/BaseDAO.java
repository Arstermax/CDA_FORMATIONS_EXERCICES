package exercice.Zoo.DAO;

import exercice.Zoo.Entity.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<T> {
    protected Connection _connection;
    protected PreparedStatement preparedStatement;
    protected String request;
    protected ResultSet resultSet;
    protected BaseDAO (Connection connection){
        this._connection = connection;
    }

}
