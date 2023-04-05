package Employee;

public class HumanResources extends Employee{
    private Specialties specialty;

    @Override
    public void setRole(Roles role) {

    }

    @Override
    public void addPrLang(String lang) {

    }

    public HumanResources(String name, String email, float salary, Specialties specialty) {
        super(name, email, salary);
        this.specialty = specialty;
    }

    public HumanResources() {

    }

    @Override
    public String toString() {
        return "HUMAN RESOURCES: " + super.toString();
    }
}
