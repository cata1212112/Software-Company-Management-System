package Employee;

public class EmployeeBuilder {
    private Employee employee;

    public EmployeeBuilder(Employee employee) {
        this.employee = employee;
    }

    public EmployeeBuilder withName(String name) {
        employee.setName(name);
        return this;
    }

    public EmployeeBuilder withEmail(String name) {
        employee.setEmail(name);
        return this;
    }

    public EmployeeBuilder withSalary(float salary) {
        employee.setSalary(salary);
        return this;
    }

    public EmployeeBuilder withRole(Role.Position role) {
        employee.setRole(role);
        return this;
    }

    public EmployeeBuilder withTeamID(int team_id) {
        employee.setTeam_id(team_id);
        return this;
    }
    public EmployeeBuilder withProgrammingLanguages(String []lang) {
        employee.addPrLang(lang);
        return this;
    }

    public Employee build() {
        return this.employee;
    }
}
