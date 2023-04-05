package Employee;

public class Tester extends Employee{
    public Tester(String name, String email, float salary) {
        super(name, email, salary);
    }

    public Tester() {

    }

    @Override
    public void setRole(Roles role) {

    }

    @Override
    public void addPrLang(String lang) {

    }

    @Override
    public String toString() {
        return "TESTER: " + super.toString();
    }
}
