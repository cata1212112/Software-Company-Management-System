package Model.Project;

import Repositories.TaskRepository;

public class Task {

    private static int id = 0;
    private int task_id;
    private String description;
    private int priority;
    private boolean isAssigned = false;
    private int projectID;

    private Integer assignedEmployeeID = null;

    {
        this.task_id = id++;
    }

    public int getTask_id() {
        return task_id;
    }

    public Task(String description, int priority, int projectID) {
        this.description = description;
        this.priority = priority;
        this.projectID = projectID;
    }

    public Task(int task_id, String description, int priority, boolean isAssigned, int projectID, Integer assignedEmployeeID) {
        id = Math.max(id, task_id+1);
        this.task_id = task_id;
        this.description = description;
        this.priority = priority;
        this.isAssigned = isAssigned;
        this.projectID = projectID;
        this.assignedEmployeeID = assignedEmployeeID;
    }

    @Override
    public String toString() {
        String tmp;
        if (this.isAssigned) {
            tmp =  "TASK: " + this.task_id + " ASSIGNED EMPLOYEE " + this.assignedEmployeeID + " PRIORITY: " + this.priority + " PROJECT: " + this.projectID  + " DESCRIPTION: " + this.description;
        } else {
            tmp =  "TASK: " + this.task_id + " NOT ASSIGNED: "+ " PRIORITY: " + this.priority + " PROJECT: " + this.projectID  + " DESCRIPTION: " + this.description;
        }
        return tmp;
    }

    public void setAssignedEmployeeID(Integer assignedEmployeeID) {
        if (assignedEmployeeID < 0) {
            this.isAssigned = false;
            this.assignedEmployeeID = null;
        } else {
            this.assignedEmployeeID = assignedEmployeeID;
            this.isAssigned = true;
        }

        TaskRepository.getInstance().update(this);
    }

    public Integer getAssignedEmployeeID() {
        return this.assignedEmployeeID;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getProjectID() {
        return projectID;
    }
}
