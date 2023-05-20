package Exceptions;

public class IllegalPosition extends Exception{
    public IllegalPosition(String pos) {
        super("Provided position: " + pos + " does not exist!");
    }
}
