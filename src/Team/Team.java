package Team;

import Department.Department;
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
        observers = new ArrayList<>();
    }
    public Team(String name) {
        this.name = name;
        employees = new TreeMap<>();
    }

    public Team(int id, String name) {
        this.team_id = id;
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

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addEmployee(Employee e) {
        employees.put(e.getEmployee_id(), e);

        observers.forEach(obs -> obs.update(e));
    }

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

    public void removeEmployee(int employeeID) {
        try {
            this.employees.get(employeeID).setTeam_id(-1);
            this.employees.remove(employeeID);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkEmployee(int employeeID) {
        return this.employees.values().stream().anyMatch(x->x.getEmployee_id()==employeeID);
    }

}
