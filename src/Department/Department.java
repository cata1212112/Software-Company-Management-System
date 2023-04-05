package Department;

import Employee.Employee;
import Team.Team;

import java.util.ArrayList;
import java.util.Map;

public abstract class Department {
    protected ArrayList<Employee> employees;
    protected String name;

    protected Map<String, Team> teams;

    public void addTeam(Team team) {
        this.teams.put(team.getName(), team);
    }
}
