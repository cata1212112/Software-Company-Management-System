package Commands;

import Team.Team;

public class CreateTeam implements Command{
    private String department;
    private String nume;


    public CreateTeam(String department, String nume) {
        this.department = department;
        this.nume = nume;
    }

    @Override
    public void execute() {
        switch (this.department) {
            case "IT" -> departmentIT.get().addTeam(new Team(this.nume));
            case "HR" -> departmentHR.get().addTeam(new Team(this.nume));
            case "Marketing" -> departmentMarketing.get().addTeam(new Team(this.nume));
        }
    }
}
