package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Group;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public interface GroupDAO {

    void create(Group group) throws DBException;

    Group getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Group group) throws DBException;

    List<Group> getAll() throws DBException;

}
