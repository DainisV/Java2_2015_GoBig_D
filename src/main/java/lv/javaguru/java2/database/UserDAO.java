package lv.javaguru.java2.database.DAO;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface UserDAO {

    void create(User user) throws DBException;

    void delete(Long id) throws DBException;

    void update(User user) throws DBException;

    User getById(Long id) throws DBException;

    List<User> getAll() throws DBException;

    User getUserByUsername(String username) throws DBException;

}
