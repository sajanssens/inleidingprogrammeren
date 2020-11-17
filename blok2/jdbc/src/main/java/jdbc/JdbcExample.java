package jdbc;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws SQLException {

        // 1
        // Class.forName("com.mysql.cj.jdbc.Driver"); // not necessary since Java 6; now via the SPI

        // 2
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");

        // 3
        Statement statement = connection.createStatement();

        // 4
        ResultSet result = statement.executeQuery(
                "select person.name, person.age, gender.name\n" +
                        "from person\n" +
                        "    join gender on person.genderId = gender.id\n" +
                        "where age > 0");

        // 5
        while (result.next()) {
            String name = result.getString("name");
            String gendername = result.getString("gender.name");
            int age = result.getInt("age");

            System.out.println(name + ", " + age + " jaar is een " + gendername);
        }

        // 6
        statement.close();
        connection.close();
    }
}
