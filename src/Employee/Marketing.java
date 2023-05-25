package Employee;

import java.util.ArrayList;

public class Marketing extends Employee{
    public Marketing(String name, String email, float salary) {
        super(name, email, salary);
    }

    public Marketing(int employee_id, String name, String email, int team_id, float salary, Role.Position role) {
        super(employee_id, name, email, team_id, salary, role);
    }

    @Override
    public void addPrLang(String[] lang) {

    }

    public Marketing() {

    }

    @Override
    public String toString() {
        return "Marketing: " + super.toString();
    }

    @Override
    public String getDep() {
        return "MARKETING";
    }

    @Override
    public ArrayList<String> getPrLag() {
        return null;
    }
}
