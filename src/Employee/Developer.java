package Employee;

import java.util.ArrayList;

public class Developer extends Employee{
    private ArrayList<String> programmingLanguages;
    private Roles role;

    public Developer() {

    }
    public Developer(String name, String email, float salary, Roles role) {
        super(name, email, salary);
        this.programmingLanguages = new ArrayList<>();
        this.role = role;
    }

    @Override
    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public void addPrLang(String lang) {
        this.programmingLanguages.add(lang);
    }

    @Override
    public String toString() {
        return "DEVELOPER: " + super.toString();
    }
}
