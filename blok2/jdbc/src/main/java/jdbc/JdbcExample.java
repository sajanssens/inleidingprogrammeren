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
        ResultSet result = statement.executeQuery("SELECT * FROM PERSON");

        // 5
        while (result.next()) {
            String name = result.getString("name");
            int age = result.getInt("age");

            System.out.println(name + " - " + age);
        }

        // 6
        statement.close();
        connection.close();
    }
}
