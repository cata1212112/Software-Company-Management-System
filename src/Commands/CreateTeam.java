package Commands;

import Employee.Role;
import Exceptions.IllegalDepartment;
import Team.Team;

public class CreateTeam implements Command{
    private Role department;
    private String dep;
    private String nume;


    public CreateTeam(String line) {
        String[] lines = line.split(" ");
        this.dep = lines[1].toUpperCase();
        this.nume = lines[2];
    }

    @Override
    public void execute() throws IllegalDepartment {
        try {
            this.department = Role.valueOf(this.dep);
            switch (this.department) {
                case DEVELOPER -> departmentIT.get().addTeam(new Team(this.nume));
                case HR -> departmentHR.get().addTeam(new Team(this.nume));
                case MARKETING -> departmentMarketing.get().addTeam(new Team(this.nume));
                default -> throw new IllegalDepartment(this.department.toString());
            }
        } catch (Exception e) {
            throw new IllegalDepartment(this.dep);
        }
    }
}
