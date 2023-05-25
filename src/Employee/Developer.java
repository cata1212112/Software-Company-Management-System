package Employee;

import java.util.ArrayList;

public class Developer extends Employee{
    private ArrayList<String> programmingLanguages;

    public Developer() {
        programmingLanguages = new ArrayList<>();
    }
    public Developer(String name, String email, float salary) {
        super(name, email, salary);
        this.programmingLanguages = new ArrayList<>();
    }

    public Developer(int employee_id, String name, String email, int team_id, float salary, Role.Position role, ArrayList<String> programmingLanguages) {
        super(employee_id, name, email, team_id, salary, role);
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public void addPrLang(String []lang) {
        for (String x:lang) {
            this.programmingLanguages.add(x);
        }
    }

    @Override
    public String toString() {
        return "DEVELOPER: " + super.toString();
    }

    @Override
    public String getDep() {
        return "DEVELOPER";
    }

    @Override
    public ArrayList<String> getPrLag() {
        return this.programmingLanguages;
    }
}
