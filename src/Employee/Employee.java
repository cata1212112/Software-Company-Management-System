package Employee;

import java.util.ArrayList;

public abstract class Employee {
    private static int id = 0;

    protected int employee_id;
    protected String name;
    protected String email;

    private int team_id;
    protected float salary;

    private Role.Position role;

    {
        employee_id = id++;
    }

    public Employee() {

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public Employee(String name, String email, float salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Employee(int employee_id, String name, String email, int team_id, float salary, Role.Position role) {
        this.employee_id = employee_id;
        this.name = name;
        this.email = email;
        this.team_id = team_id;
        this.salary = salary;
        this.role = role;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setRole(Role.Position role) {
        this.role = role;
    }

    public abstract void addPrLang(String []lang);

    @Override
    public String toString() {
        return "ID: " + this.employee_id + " NAME: " + this.name + " EMAIL: " + this.email + " TEAM: " + this.team_id + " ROLE " + this.role;
    }

    public float getSalary() {
        return salary;
    }

    public abstract String getDep();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getTeam_id() {
        return team_id;
    }

    public Role.Position getRole() {
        return role;
    }

    public abstract ArrayList<String> getPrLag();
}
