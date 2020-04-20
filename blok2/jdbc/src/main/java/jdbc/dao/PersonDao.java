package jdbc.dao;

import jdbc.domain.Gender;
import jdbc.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.MyProperties.get;

public class PersonDao {

    public List<Person> getPersons() throws SQLException {
        try (Connection connection = DriverManager.getConnection(get("database.url"), get("database.user"), get("database.password"));
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM person");
            return showRows(result);
        }
    }

    public List<Person> getPersonsWithGender() throws SQLException {
        try (Connection connection = DriverManager.getConnection(get("database.url"), get("database.user"), get("database.password"));
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(
                    "select person.name, person.age, gender.name\n" +
                            "from person\n" +
                            "    join gender on person.genderId = gender.id\n" +
                            "where age > 0");

            return showRows(result);
        }
    }

    public List<Person> getPersonsByName(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(get("database.url"), get("database.user"), get("database.password"));
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM person where name LIKE ?")) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            return showRows(result);
        }
    }

    public int insert(Person p) throws SQLException {
        try (Connection connection = DriverManager.getConnection(get("database.url"), get("database.user"), get("database.password"));
             PreparedStatement statement = connection.prepareStatement("INSERT INTO person(name, age, genderId) VALUES (?, ?,  ?)")) {
            statement.setString(1, p.name);
            statement.setInt(2, p.age);
            statement.setInt(3, p.gender.ordinal() + 1);
            return statement.executeUpdate();
        }
    }

    private List<Person> showRows(ResultSet result) throws SQLException {
        List<Person> persons = new ArrayList<>();
        while (result.next()) {
            String name = result.getString("person.name");
            int age = result.getInt("person.age");
            Gender gender = getGender(result);

            Person person = new Person(name, age, gender);
            persons.add(person);
        }
        return persons;
    }

    private Gender getGender(ResultSet result) {
        Gender g = Gender.Onbekend;
        try {
            g = Gender.valueOf(result.getString("gender.name"));
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return g;
    }

}
