package jdbc;

import jdbc.dao.PersonDao;
import jdbc.domain.Person;

import java.sql.SQLException;

import static jdbc.domain.Gender.Vrouw;

public class JdbcExampleRefactored {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao(); // data access object

        try {
            personDao.createDatabase();
            personDao.getPersons().forEach(System.out::println);
            personDao.getPersonsWithGender().forEach(System.out::println);
            personDao.getPersonsByName("Bram").forEach(System.out::println);
            int mieke = personDao.insert(new Person("Mieke", 40, Vrouw));
            System.out.println(mieke);
        } catch (SQLException e) {
            System.err.println("Query ging fout: " + e.getMessage());
        }
    }
}
