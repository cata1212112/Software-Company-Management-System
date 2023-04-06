package Commands;

import Employee.*;

public class ShowTeams implements Command{

    private Role department;

    public ShowTeams(String line) {
        String[] lines = line.split(" ");
        this.department = Role.valueOf(lines[1].toUpperCase());
    }

    @Override
    public void execute() {
        switch (this.department) {
            case DEVELOPER -> departmentIT.get().showTeams();
            case HR -> departmentHR.get().showTeams();
            case MARKETING -> departmentMarketing.get().showTeams();
            default -> System.out.println("Invalid department.");
        }
    }

}