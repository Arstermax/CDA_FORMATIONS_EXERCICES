package exercice.Zoo.DAO;

import exercice.Zoo.Entity.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalDAO extends BaseDAO<Animal> {
    PreparedStatement preparedStatement;
    private AnimalDAO animalDAO;

    public AnimalDAO(Connection connection) {
        super(connection);
        AnimalDAO animalDAO;
    }


    public Animal Add(Animal animal) throws SQLException {
        try {
            // 1 - Requête SQL pour ajouter un Animal
            request = "INSERT INTO animal(name,race, description, habitat,age) VAKUE(?,?,?,?,?)";
            // 2 - Préparation des Valeurs de la requête [Cette manière de faire évite les injections SQL]
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getRace());
            preparedStatement.setString(3, animal.getDescription());
            preparedStatement.setString(4, animal.getHabitat());
            preparedStatement.setInt(5, animal.getAge());
            // indique le nombre execution fait [Permet de savoir si la requête, c'est correctement dérouler]
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            Animal animal = null;
            if (resultSet.next())
                animal = Animal.builder()
                        .id(resultSet.getInt(1)) // indique un nombre pour id
                        .name(animal.getName())
                        .race(animal.getRace())
                        .description(animal.getDescription())
                        .habitat(animal.getHabitat())
                        .age(animal.getAge())
                        .build();
            // Vérifie le nombre de modifications dans ce code
            if (nbrow > 1) _connection.rollback();
            _connection.commit();
            return animal;
        } catch (SQLException e) {
            _connection.rollback();
            return null;
        }
    }
}
