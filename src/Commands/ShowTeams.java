package Commands;

import Model.Employee.*;
import Exceptions.IllegalDepartment;

public class ShowTeams implements Command{

    private Role department;
    private String dep;

    public ShowTeams(String line) {
        String[] lines = line.split(" ");
        this.dep = lines[1].toUpperCase();
    }

    @Override
    public void execute() throws IllegalDepartment {
        try {
            this.department = Role.valueOf(this.dep);
            switch (this.department) {
                case DEVELOPER -> departmentIT.get().showTeams();
                case HR -> departmentHR.get().showTeams();
                case MARKETING -> departmentMarketing.get().showTeams();
                default -> throw new IllegalDepartment(this.department.toString());
            }
        } catch (Exception e) {
            throw new IllegalDepartment(this.dep);
        }
    }

}