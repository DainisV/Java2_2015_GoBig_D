package lv.javaguru.java2.domain;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public class Person {

    private long personId;
    private String firstName;
    private String lastName;


    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
    public Person() {

    }
}
