package Exceptions;

public class ProjectNotFound extends Exception{
    public ProjectNotFound(int id) {
        super("Provided project: " + id + " does not exist!");
    }
}
