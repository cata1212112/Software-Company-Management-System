package Commands;

import Employee.*;

import java.util.Arrays;

public class AddEmployeeToTeam implements Command{
    private String name;
    private String email;
    private float salary;
    private Role.Position position;
    private Role role;
    private int teamId;
    private String[] programmingLanguages;


    public AddEmployeeToTeam(String line) {
        String[] lines = line.split(" ");
        this.name = lines[1];
        this.email = lines[2];
        this.salary = Float.parseFloat(lines[3]);
        this.position = Role.Position.valueOf(lines[4].toUpperCase());
        this.teamId = Integer.parseInt(lines[5]);
        this.programmingLanguages = Arrays.copyOfRange(lines, 6, lines.length);
    }

    @Override
    public void execute() {
        switch (this.position) {
            case HR_ASSISTANT:
            case HR_MANAGER:
                this.role = Role.HR;
                break;
            case MARKETING_ASSISTANT:
            case MARKETING_MANAGER:
                this.role = Role.MARKETING;
                break;
            case JUNIOR_DEVELOPER:
            case SENIOR_DEVELOPER:
                this.role = Role.DEVELOPER;
                break;
            default:
                throw new IllegalArgumentException("Unknown position: " + this.position);
        }

        // Create new employee
        Employee employee = new EmployeeBuilder(EmployeeFactory.getEmployee(role))
                .withEmail(this.email)
                .withName(this.name)
                .withSalary(this.salary)
                .withTeamID(this.teamId)
                .withProgrammingLanguages(this.programmingLanguages)
                .withRole(this.position)
                .build();

        switch (this.position) {
            case JUNIOR_DEVELOPER, SENIOR_DEVELOPER -> departmentIT.get().getTeams().get(this.teamId).addEmployee(employee);
            case HR_ASSISTANT, HR_MANAGER -> departmentHR.get().getTeams().get(this.teamId).addEmployee(employee);
            case MARKETING_ASSISTANT, MARKETING_MANAGER -> departmentMarketing.get().getTeams().get(this.teamId).addEmployee(employee);
            default -> System.out.println("Invalid department.");
        }

    }
}
