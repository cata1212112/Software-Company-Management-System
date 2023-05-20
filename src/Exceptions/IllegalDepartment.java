package Exceptions;

public class IllegalDepartment extends Exception{
    public IllegalDepartment(String dp) {
        super("Provided department: " + dp + " does not exist!");
    }
}
