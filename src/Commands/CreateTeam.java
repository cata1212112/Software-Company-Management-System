package Commands;

import Employee.Role;
import Team.Team;

public class CreateTeam implements Command{
    private Role department;
    private String nume;


    public CreateTeam(String line) {
        String[] lines = line.split(" ");
        this.department = Role.valueOf(lines[1].toUpperCase());;
        this.nume = lines[2];
    }

    @Override
    public void execute() {
        switch (this.department) {
            case DEVELOPER -> departmentIT.get().addTeam(new Team(this.nume));
            case HR -> departmentHR.get().addTeam(new Team(this.nume));
            case MARKETING -> departmentMarketing.get().addTeam(new Team(this.nume));
            default -> System.out.println("Invalid department.");
        }
    }
}
