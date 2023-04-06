package Employee;

public class EmployeeFactory {
    private EmployeeFactory() {

    }

    public static Employee getEmployee(Role role) {
        if (role.equals(Role.DEVELOPER)) {
            return new Developer();
        } else if (role.equals(Role.MARKETING)) {
            return new MarketingAssistant();
        } else if (role.equals(Role.HR)) {
            return new HumanResources();
        }
        return null;
    }

}