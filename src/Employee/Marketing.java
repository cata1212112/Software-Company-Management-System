package Employee;

public class Marketing extends Employee{
    public Marketing(String name, String email, float salary) {
        super(name, email, salary);
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
}
