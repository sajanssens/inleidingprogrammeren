package jdbc;

import java.sql.*;

import static jdbc.MyProperties.get;

public class App {

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        try {
            // loadDriver();
            try (Connection connection = createConnection()) {
                Statement statement = createStatement(connection);
                ResultSet resultSet = statement.executeQuery("SELECT * from person");
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println(name);
                    System.out.println(age);
                }
                ResultSetMetaData metaData = resultSet.getMetaData();
                String catalogName = metaData.getCatalogName(1);
                System.out.println(catalogName);
            }
            // } catch (ClassNotFoundException e) {
            //     System.err.println("JDBC driver not found; exiting... Details: \n" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQLException occured; exiting... Details: \n" + e.getMessage());
        }
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName(get("database.driver"));
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(get("database.url"), get("database.user"), get("database.password"));
    }

    private Statement createStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

}
