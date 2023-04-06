package Team;

import Employee.Employee;
import Observer.Observer;
import Project.*;

import java.util.*;

public class Team {
    private static int id;
    private int team_id;
    private String name;
    protected Map<Integer, Employee> employees;

    private ArrayList<Project> projects = new ArrayList<>();

    private List<Observer> observers;

    {
        team_id = id++;
    }
    public Team(String name) {
        this.name = name;
        employees = new TreeMap<>();
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
    public String getName() {
        return name;
    }

    public void setObserves(List<Observer> observers) {
        this.observers = observers;
    }


    /**
     * Add, Remove and Notify methods for Observer Design Pattern
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addEmployee(Employee e) {
        // Add to the employee Map
        employees.put(e.getEmployee_id(), e);

        // Notify the observers a new Employee exists
        observers.forEach(obs -> obs.update(e));
    }

    /**
     * Methods for Projects
     * @param pr
     */
    public void addProject(Project pr) {
        projects.add(pr);
    }

    public Project getProjectByID(int id) {
        for (int i=0; i<this.projects.size(); i++) {
            if (this.projects.get(i).getProject_id() == id) {
                return this.projects.get(i);
            }
        }
        return null;
    }

    public void showProjects() {
        System.out.println("Projects:");
        projects.stream()
                .map(Project::toString)
                .forEach(System.out::println);
    }


    @Override
    public String toString() {
        return "TEAM " + " " + this.team_id + " NAME: " + name;
    }

    public int getId() {
        return team_id;
    }

    public void removeProject(Project pr) {
        this.projects.remove(pr);
    }


}
