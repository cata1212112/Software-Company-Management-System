package Exceptions;

public class EmployeeNotFound extends Exception{

    public EmployeeNotFound(int id) {
        super("Provided employee: " + id + " does not exist!");
    }

}
