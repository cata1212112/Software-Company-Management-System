package Employee;

public class HumanResources extends Employee{

    @Override
    public void addPrLang(String []lang) {

    }

    public HumanResources(String name, String email, float salary) {
        super(name, email, salary);
    }

    public HumanResources() {

    }

    @Override
    public String toString() {
        return "HUMAN RESOURCES: " + super.toString();
    }
}
