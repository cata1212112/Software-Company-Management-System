package Project;

import Employee.Employee;

import java.util.Date;

public class Task {

    private static int id = 0;
    private int task_id;
    private String description;
    private int priority;
    private boolean isAssigned = false;
    private int projectID;

    private int assignedEmployeeID;

    {
        this.task_id = id++;
    }

    public int getTask_id() {
        return task_id;
    }

    public Task(String description, int priority, int assignedEmployeeID, int projectID) {
        this.description = description;
        this.priority = priority;
        this.assignedEmployeeID = assignedEmployeeID;
        this.projectID = projectID;
    }

    @Override
    public String toString() {
        return "TASK: " + this.task_id + " PRIORITY: " + this.priority + " PROJECT: " + this.projectID  + " DESCRIPTION: " + this.description;
    }

    public void setAssignedEmployeeID(int assignedEmployeeID) {
        this.assignedEmployeeID = assignedEmployeeID;
    }
}
