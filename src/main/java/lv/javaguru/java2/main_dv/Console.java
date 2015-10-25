package lv.javaguru.java2.main_dv;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.GroupDAO;
import lv.javaguru.java2.database.jdbc.GroupDAOImpl;
import lv.javaguru.java2.database.jdbc.PersonDAOImpl;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.Group;
import lv.javaguru.java2.domain.Person;
import lv.javaguru.java2.domain.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AST on 2015.09.20..
 */
public class Console {
    //public Console(){};

    //List<Student> groupOffStudents;
    //Student student = new Student();
    User consoleUser;



    public void executeUserChoice(int userInput) throws ClassNotFoundException, DBException {
        switch (userInput){
            case 1 :
                runUserMenu();
                break;
            case 2 :
                System.out.println("Login Username: ");
                String username = getUserInputString();
                System.out.println("Login Password: ");
                String password = getUserInputString();
                if(usernameOrPasswordNotValid(username, password)) {
                    System.out.println("Username and password incorrect !");
                    break;
                }
                UserDAOImpl userDAO = new UserDAOImpl();
                consoleUser = userDAO.getUserByUsername(username);
                System.out.println("Current user: " + consoleUser.getUsername());
                break;
            case 3 :
                userDAO = new UserDAOImpl();
                List<User> userList = userDAO.getAll();
                printUsersList(userList);
                break;
            case 4 :
                runGroupMenu();
                break;
            case 5 :
                runGroupMenu();
                break;
            case 6 :
                runGroupMenu();
                break;
            case 7 :
                runPersonMenu();
                break;
            case 8 :
                runPersonMenu();
                break;
            case 9 :
                runPersonMenu();
                break;
            case 10 :
                System.out.println("Option : 10");
                break;
            case 11 :
                System.out.println("Option : 11");
                break;
            case 12 :
                System.out.println("Option : 12");
                break;
            case 0 :
                break;
            default:
                System.out.println("Wrong choice, here are available choices: ");

        }
    }

    private boolean usernameOrPasswordNotValid(String username, String password) throws DBException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUsername(username);
        if(user == null)
            return true;
        if(!user.getPassword().equals(password))
            return true;
        return false;
    }

    public void executeUserChoiceFromUserMenu(int userInput) throws ClassNotFoundException, DBException {
        switch (userInput){
            case 1 :
                System.out.println("Register Username: ");
                String username = getUserInputString();
                System.out.println("Register Password: ");
                String password = getUserInputString();
                System.out.println("Repeat Password: ");
                String passwordRepeated = getUserInputString();
                System.out.println("Register email: ");
                String email = getUserInputString();
                if(usernameNotValid(username)) {
                    System.out.println("Username already used, choose another one !");
                    break;
                }
                if(!password.equals(passwordRepeated)) {
                    System.out.println("Password input incorrect , try again !");
                    break;
                }
                User user = new User(username, password, email);
                UserDAOImpl userDAO = new UserDAOImpl();
                userDAO.create(user);
                //consoleUser = user;
                break;
            case 2 :
                System.out.println("Input User Id: ");
                long userId = getUserInput();
                userDAO = new UserDAOImpl();
                userDAO.delete(userId);
                break;
            case 3 :
                userDAO = new UserDAOImpl();
                List<User> userList = userDAO.getAll();
                printUsersList(userList);
                break;
            case 0 :
                break;
            default:
                System.out.println("Wrong choice, here are available choices: ");

        }
    }

    private boolean usernameNotValid(String username) throws DBException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUsername(username);
        if(user == null)
            return false;
        return true;
    }

    public void executeUserChoiceFromGroupMenu(int userInput) throws ClassNotFoundException, DBException {
        switch (userInput){
            case 1 :
                System.out.println("Input Name: ");
                String groupName = getUserInputString();
                System.out.println("Input Description: ");
                String groupDescription = getUserInputString();
                Group group = new Group(groupName, groupDescription);
                GroupDAO groupDAO = new GroupDAOImpl();
                groupDAO.create(group);
                break;
            case 2 :
                System.out.println("Input Person ID: ");
                long groupID = getUserInput();
                groupDAO = new GroupDAOImpl();
                groupDAO.delete(groupID);
                break;
            case 3 :
                groupDAO = new GroupDAOImpl();
                List<Group> groupList = groupDAO.getAll();
                printGroupsList(groupList);
                break;
            case 0 :
                break;
            default:
                System.out.println("Wrong choice, here are available choices: ");

        }
    }
    public void executeUserChoiceFromPersonMenu(int userInput) throws ClassNotFoundException, DBException {
        switch (userInput){
            case 1 :
                System.out.println("Input First name: ");
                String userFirstName = getUserInputString();
                System.out.println("Input Last name: ");
                String userLastName = getUserInputString();
                Person person = new Person(userFirstName, userLastName);
                PersonDAOImpl personDAO = new PersonDAOImpl();
                personDAO.create(person);
                break;
            case 2 :
                System.out.println("Input Person ID: ");
                long personID = getUserInput();
                personDAO = new PersonDAOImpl();
                personDAO.delete(personID);
                break;
            case 3 :
                personDAO = new PersonDAOImpl();
                List<Person> personList = personDAO.getAll();
                printPersonsList(personList);
                break;
            case 0 :
                break;
            default:
                System.out.println("Wrong choice, here are available choices: ");

        }
    }
    public void showMenu(){
        System.out.println(" _______________________________________________________________");
        System.out.println("| This is a person estimate application. Enter your choice:     |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 1 - User create/remove/list                                   |");
        System.out.println("| 2 - Login User                                              |");
        System.out.println("| 3 - List Users                                               |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 4 - Group create/remove for currant User/                     |");
        System.out.println("| *5 - Select Group                                             |");
        System.out.println("| *6 - List Groups for currant User/                            |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 7 - Person create/remove for currant User/Group/              |");
        System.out.println("| *8 - Select Person                                            |");
        System.out.println("| *9 - List Persons for currant User/Group/                     |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| *10 - Course create/remove                                    |");
        System.out.println("| *11 - Select Course                                           |");
        System.out.println("| *12 - List Courses for currant User/Group/                    |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| *13 - Assess students by name and subject                     |");
        System.out.println("| *14 - Calculate average value for student by name             |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 0 - Exit                                                      |");
        System.out.println("|_______________________________________________________________|");
        System.out.print("User:" + consoleUser.getUsername() + ">");
    }
    public void showLoginMenu(){
        System.out.println(" _______________________________________________________________");
        System.out.println("| Enter your choice:                                            |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 1 - Login                                                     |");
        System.out.println("| 2 - Forgot Password                                           |");
        System.out.println("| 3 - Register                                                  |");
        System.out.println("| 0 - Exit                                                      |");
        System.out.println("|_______________________________________________________________|");
    }
    public void showUsersMenu(){
        System.out.println(" _______________________________________________________________");
        System.out.println("| Enter your choice:                                            |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 1 - Create User                                               |");
        System.out.println("| 2 - Remove User by ID                                         |");
        System.out.println("| 3 - List Users                                                |");
        System.out.println("| 0 - Exit to main menu                                         |");
        System.out.println("|_______________________________________________________________|");
    }

    public void showGroupsMenu(){
        System.out.println(" _______________________________________________________________");
        System.out.println("| Enter your choice:                                            |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 1 - Create new Group                                          |");
        System.out.println("| 2 - Remove Group by ID                                        |");
        System.out.println("| 3 - List Groups                                               |");
        System.out.println("| 0 - Exit to main menu                                         |");
        System.out.println("|_______________________________________________________________|");
    }
    public void showPersonsMenu(){
        System.out.println(" _______________________________________________________________");
        System.out.println("| Enter your choice:                                            |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("| 1 - Create new Person                                         |");
        System.out.println("| 2 - Remove Person by ID                                       |");
        System.out.println("| 3 - List Persons                                              |");
        System.out.println("| 0 - Exit to main menu                                         |");
        System.out.println("|_______________________________________________________________|");
    }
    public int getUserInput(){
        int userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
        }catch (InputMismatchException ime) {
            ime.printStackTrace();
        }
        return userInput;
    }
    public String getUserInputString(){
        String userInput = null;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
        }catch (InputMismatchException ime) {
            ime.printStackTrace();
        }
        return userInput;
    }
    public void runMainMenu() {
        boolean runProgram = true;
        while (runProgram) {
            try {
                showMenu();
                int userChoice = getUserInput();
                executeUserChoice(userChoice);
                if (userChoice == 0)
                    runProgram = false;
            }catch (RegisterException ce) {
                ce.printMessage();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void runUserMenu() {
        boolean runProgram = true;
        while (runProgram) {
            try {
                showUsersMenu();
                int userChoice = getUserInput();
                executeUserChoiceFromUserMenu(userChoice);
                if (userChoice == 0)
                    runProgram = false;
            }catch (RegisterException ce) {
                ce.printMessage();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void runGroupMenu() {
        boolean runProgram = true;
        while (runProgram) {
            try {
                showGroupsMenu();
                int userChoice = getUserInput();
                executeUserChoiceFromGroupMenu(userChoice);
                if (userChoice == 0)
                    runProgram = false;
            }catch (RegisterException ce) {
                ce.printMessage();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void runPersonMenu() {
        boolean runProgram = true;
        while (runProgram) {
            try {
                showPersonsMenu();
                int userChoice = getUserInput();
                executeUserChoiceFromPersonMenu(userChoice);
                if (userChoice == 0)
                    runProgram = false;
            }catch (RegisterException ce) {
                ce.printMessage();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void printUsersList(List<User> list){
        System.out.println("Id  " + " \t: " + "Username");
        for(User user: list)
            System.out.println(user.getUserId() + " \t: " + user.getUsername());
    }
    public void printPersonsList(List<Person> list){
        for(Person person: list)
            System.out.println(person.getPersonId() + " \t: " + person.getFirstName() + " \t: " + person.getLastName());
    }
    public void printGroupsList(List<Group> list){
        for(Group group: list)
            System.out.println(group.getGroupId() + " \t: " + group.getName() + " \t: " + group.getDescription());
    }

    public boolean runLogin() {
        boolean runProgram = true;
        while (runProgram) {
            try {
                showLoginMenu();
                int userChoice = getUserInput();
                executeLogin(userChoice);
                if (userChoice == 0)
                    return false;
                runMainMenu();
            }catch (RegisterException ce) {
                ce.printMessage();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return true;
    }

    private void executeLogin(int userInput) throws DBException {
        switch (userInput) {
            case 1:
                System.out.println("Login Username: ");
                String username = getUserInputString();
                System.out.println("Login Password: ");
                String password = getUserInputString();
                if (usernameOrPasswordNotValid(username, password)) {
                    System.out.println("Username and password incorrect !");
                    break;
                }
                UserDAOImpl userDAO = new UserDAOImpl();
                consoleUser = userDAO.getUserByUsername(username);
                System.out.println("Current user: " + consoleUser.getUsername());
                break;
            case 2:
                System.out.println("Enter email: ");
                long userId = getUserInput();
                userDAO = new UserDAOImpl();
                //userDAO.delete(userId);
                break;
            case 3:
                System.out.println("Register Username: ");
                username = getUserInputString();
                System.out.println("Register Password: ");
                password = getUserInputString();
                System.out.println("Repeat Password: ");
                String passwordRepeated = getUserInputString();
                System.out.println("Register email: ");
                String email = getUserInputString();
                if (usernameNotValid(username)) {
                    System.out.println("Username already used, choose another one !");
                    break;
                }
                if (!password.equals(passwordRepeated)) {
                    System.out.println("Password input incorrect , try again !");
                    break;
                }
                User user = new User(username, password, email);
                userDAO = new UserDAOImpl();
                userDAO.create(user);
                break;
            case 0 :
                System.out.println("Good buy!");
                break;
            default:
                System.out.println("Wrong choice, here are available choices: ");
        }
    }

    public void runConsole() {
        boolean runProgram = true;
        while (runProgram) {
            try {
                runProgram = runLogin();
                if (runProgram == false) {
                    break;
                }
            }catch (RegisterException ce) {
                ce.printMessage();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
