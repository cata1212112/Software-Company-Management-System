package Employee;

import java.util.ArrayList;

public class HumanResources extends Employee{

    @Override
    public void addPrLang(String []lang) {

    }

    public HumanResources(String name, String email, float salary) {
        super(name, email, salary);
    }

    public HumanResources(int employee_id, String name, String email, int team_id, float salary, Role.Position role) {
        super(employee_id, name, email, team_id, salary, role);
    }

    public HumanResources() {

    }

    @Override
    public String toString() {
        return "HUMAN RESOURCES: " + super.toString();
    }

    @Override
    public String getDep() {
        return "HR";
    }

    @Override
    public ArrayList<String> getPrLag() {
        return null;
    }
}
