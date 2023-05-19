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
}
