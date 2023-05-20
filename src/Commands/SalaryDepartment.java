package Commands;

import Employee.*;
import Exceptions.IllegalDepartment;

public class SalaryDepartment implements Command{
    private Role department;
    private String dep;

    public SalaryDepartment(String line) {
        String[] lines = line.split(" ");
        this.dep = lines[1].toUpperCase();
    }

    @Override
    public void execute() throws IllegalDepartment {
        try {
            this.department = Role.valueOf(this.dep);
            switch (this.department) {
                case DEVELOPER -> System.out.println(departmentIT.get().salary());
                case HR -> System.out.println(departmentHR.get().salary());
                case MARKETING -> System.out.println(departmentMarketing.get().salary());
                default -> throw new IllegalDepartment(this.department.toString());
            }
        } catch (Exception e) {
            throw new IllegalDepartment(this.dep);
        }
    }
}
