package Exceptions;

public class TaskNotFound extends Exception{
    public TaskNotFound(int id) {
        super("Provided task: " + id + " does not exist!");
    }
}
