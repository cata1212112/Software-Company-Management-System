package Department;

import Employee.Employee;
import Team.Team;
import Observer.Observer;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class Department implements Observer {
    protected ArrayList<Employee> employees;

    protected Map<Integer, Team> teams;

    public Map<Integer, Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        this.teams.put(team.getId(), team);
        this.teams.get(team.getId()).addObserver(this);
    }

    protected Department() {
        this.employees = new ArrayList<>();
        this.teams = new TreeMap<>();
    }
    public void showEmployees() {
        for (Employee e : this.employees) {
            System.out.println(e);
        }
    }

    public void showTeams() {
        for (Team t : this.teams.values()) {
            System.out.println(t);
        }
    }

    @Override
    public void update(Employee employee) {
        this.employees.add(employee);
    }

    public float salary() {
        float sum = 0;
        for (Employee e:this.employees) {
            sum += e.getSalary();
        }
        return sum;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

}
