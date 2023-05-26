package Exceptions;

public class ProjectHasAssignedTasks extends Exception{
    public ProjectHasAssignedTasks() {
        super("Project has assigned tasks, can't change teams");
    }
}
