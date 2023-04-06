package Commands;

import Employee.*;

public class ShowEmployees implements Command{

    private Role department;

    public ShowEmployees(String line) {
        String[] lines = line.split(" ");
        this.department = Role.valueOf(lines[1].toUpperCase());
    }

    @Override
    public void execute() {
            switch (this.department) {
                case DEVELOPER -> departmentIT.get().showEmployees();
                case HR -> departmentHR.get().showEmployees();
                case MARKETING -> departmentMarketing.get().showEmployees();
                default -> System.out.println("Invalid department.");
            }
    }

}
