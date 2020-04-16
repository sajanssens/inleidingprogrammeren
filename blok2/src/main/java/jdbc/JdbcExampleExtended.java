package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class JdbcExampleExtended {

    private static int randomAge = (int) (Math.random() * 100);

    public static void main(String[] args) { new JdbcExampleExtended().start(); }

    private void start() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
             Statement statement = connection.createStatement()) {
            deleteSomeRows(connection, randomAge);
            insertSomeRows(connection, randomAge);
            showSomeData(statement);
            showSomeDatabaseMetadata(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSomeData(Statement statement) throws SQLException {
        ResultSet result = statement.executeQuery("SELECT * FROM PERSON");

        showSomeResultsetMetadata(result);
        List<Person> persons = showRows(result);
        showPersons(persons);

        // rewind, retry:
        result.beforeFirst();
        showRows(result);
    }

    private void deleteSomeRows(Connection connection, int randomAge) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from person where age>?");
        preparedStatement.setInt(1, randomAge);
        int deleted = preparedStatement.executeUpdate();
        System.out.println("Rows deleted: " + deleted);
        preparedStatement.close();
    }

    private void insertSomeRows(Connection connection, int randomAge) throws SQLException {
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("insert into PERSON VALUES ('Bram', " + randomAge + ")");
        System.out.println("Rows inserted: " + i);
        statement.close();
    }

    private void showSomeDatabaseMetadata(Connection connection) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        String databaseProductName = databaseMetaData.getDatabaseProductName();
        System.out.println("DatabaseProductName: " + databaseProductName);
    }

    private void showSomeResultsetMetadata(ResultSet result) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        String catalogName = metaData.getCatalogName(1);
        String tableName = metaData.getTableName(1);
        System.out.println("Database: " + catalogName);
        System.out.println("Table: " + tableName);

        StringJoiner columnJoiner = new StringJoiner(", ");
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            JDBCType jdbcType = JDBCType.valueOf(metaData.getColumnType(i));
            String newElement = metaData.getColumnName(i) + " (" + jdbcType + ")";
            columnJoiner.add(newElement);
        }
        System.out.println("Columns: " + columnJoiner);
    }

    private List<Person> showRows(ResultSet result) throws SQLException {
        System.out.println("Rows:");
        List<Person> persons = new ArrayList<>();
        while (result.next()) {
            String name = result.getString("name");
            int age = result.getInt("age");
            persons.add(new Person(name, age));
            System.out.println("\t" + name + ", " + age);
        }
        return persons;
    }

    private void showPersons(List<Person> persons) {
        System.out.println("Persons:");
        for (Person person : persons) {
            System.out.println("\t" + person);
        }
    }

}
