package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Person;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface PersonDAO {

    void create(Person person) throws DBException;

    Person getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Person person) throws DBException;

    List<Person> getAll() throws DBException;

}
