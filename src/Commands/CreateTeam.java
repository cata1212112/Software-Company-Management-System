package Commands;

import Model.Employee.Role;
import Exceptions.IllegalDepartment;
import Exceptions.NameAlreadyInUse;
import Model.Team.Team;

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
    public void execute() throws IllegalDepartment, NameAlreadyInUse {
        long cnt1 = departmentIT.get().getTeams().values().stream().filter(t -> t.getName().equals(this.nume)).count();
        long cnt2 = departmentHR.get().getTeams().values().stream().filter(t -> t.getName().equals(this.nume)).count();
        long cnt3 = departmentMarketing.get().getTeams().values().stream().filter(t -> t.getName().equals(this.nume)).count();

        if (cnt1 > 0 || cnt2 > 0 || cnt3 > 0) {
            throw new NameAlreadyInUse(this.nume);
        }

        try {
            this.department = Role.valueOf(this.dep);
            switch (this.department) {
                case DEVELOPER -> departmentIT.get().addTeam(new Team(this.nume, this.department));
                case HR -> departmentHR.get().addTeam(new Team(this.nume, this.department));
                case MARKETING -> departmentMarketing.get().addTeam(new Team(this.nume, this.department));
                default -> throw new IllegalDepartment(this.department.toString());
            }
        } catch (Exception e) {
            throw new IllegalDepartment(this.dep);
        }
    }
}
