package Commands;

import Employee.*;
public class SalaryDepartment implements Command{
    private Role department;

    public SalaryDepartment(String line) {
        String[] lines = line.split(" ");
        this.department = Role.valueOf(lines[1].toUpperCase());
    }

    @Override
    public void execute() {
        switch (this.department) {
            case DEVELOPER -> System.out.println(departmentIT.get().salary());
            case HR -> System.out.println(departmentHR.get().salary());
            case MARKETING -> System.out.println(departmentMarketing.get().salary());
            default -> System.out.println("Invalid department.");
        }
    }
}
