package Team;

import Employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Team {
    private String name;
    protected Map<Integer, Employee> employees;

    public Team(String name) {
        this.name = name;
        employees = new TreeMap<>();
    }

    public void addEmployee(Employee e) {
        employees.put(e.getEmployee_id(), e);
    }

    public String getName() {
        return name;
    }
}
