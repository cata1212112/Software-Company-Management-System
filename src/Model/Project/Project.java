package Model.Project;

import Repositories.ProjectRepository;
import Repositories.TaskRepository;

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

    public Project(int project_id, boolean isAssigned, String name, int team_id, Date deadline, String description) {
        id = Math.max(id, project_id+1);
        this.project_id = project_id;
        this.isAssigned = isAssigned;
        this.name = name;
        this.team_id = team_id;
        this.deadline = deadline;
        this.description = description;
        tasks = new ArrayList<>();

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
        TaskRepository.getInstance().create(t);
    }

    public void addTaskToProjectNODB(Task t) {
        this.tasks.add(t);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void removeTask(Task task) {
        this.tasks.removeIf(x -> x.getTask_id() == task.getTask_id());
        TaskRepository.getInstance().delete(task.getTask_id());
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public String getName() {
        return name;
    }

    public int getTeam_id() {
        return team_id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
        ProjectRepository.getInstance().update(this);
    }
}
