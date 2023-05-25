package Exceptions;

public class NameAlreadyInUse extends Exception{
    public NameAlreadyInUse(String name) {
        super("Name: " + name + " already in use!");
    }
}
