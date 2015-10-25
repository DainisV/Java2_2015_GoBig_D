package lv.javaguru.java2.main_dv;

/**
 * Created by AST on 2015.09.21..
 */
public class RegisterException extends RuntimeException {
    String message;
    RegisterException(String message){
        super(message);
        this.message = message;
    }
    public void printMessage(){
        System.out.println(message);
    }
}
