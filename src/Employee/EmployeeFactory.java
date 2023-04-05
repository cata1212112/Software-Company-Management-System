package Employee;

import java.util.Objects;

public class EmployeeFactory {
    private EmployeeFactory() {

    }

    public static Employee getEmployee(String tip) {
        if (tip.equals("developer")) {
            return new Developer();
        } else if (tip.equals("tester")) {
            return new Tester();
        } else if (tip.equals("hr")) {
            return new HumanResources();
        }
        return null;
    }
}