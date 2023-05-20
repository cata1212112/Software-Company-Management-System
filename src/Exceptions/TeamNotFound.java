package Exceptions;

public class TeamNotFound extends Exception{
    public TeamNotFound(int id) {
        super("Provided team: " + id + " does not exist!");
    }
}
