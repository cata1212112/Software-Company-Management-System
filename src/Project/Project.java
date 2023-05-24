package Project;

import Team.Team;

import java.util.ArrayList;
import java.util.Date;

public class Project {

    private static int id = 0;
    private int project_id;
    private boolean isAssigned = false;
    private String name;
    int team_id;
    private Date deadline;
    private String description;

    private ArrayList<Task> tasks;

    {
        this.project_id = id++;
        tasks = new ArrayList<>();
    }

    public int getProject_id() {
        return project_id;
    }

    public Project() {
        tasks = new ArrayList<>();
    }
    public Project(String name, Date deadline, String description, int team_id) {
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.team_id = team_id;
    }

    public void showTasks() {
        System.out.println("Tasks:");
        tasks.stream()
                .map(Task::toString)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "PROJECT: " + this.project_id + " NAME: " + this.name + " DEADLINE: " + this.deadline + " TEAM: " + this.team_id +" DESCRIPTION: " + this.description;
    }

    public void addTask(Task t) {
        this.tasks.add(t);
    }

    public void addTaskToProject(Task t) {
        this.tasks.add(t);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void removeTask(Task task) {
        this.tasks.removeIf(x -> x.getTask_id() == task.getTask_id());
    }
}
