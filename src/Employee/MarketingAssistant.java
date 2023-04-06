package Employee;

public class MarketingAssistant extends Employee{
    public MarketingAssistant(String name, String email, float salary) {
        super(name, email, salary);
    }

    @Override
    public void addPrLang(String[] lang) {

    }

    public MarketingAssistant() {

    }

    @Override
    public String toString() {
        return "MarketingAssisant: " + super.toString();
    }
}
