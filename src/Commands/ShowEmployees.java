package Commands;

import Employee.*;
import Exceptions.IllegalDepartment;

public class ShowEmployees implements Command{

    private Role department;
    private String dep;

    public ShowEmployees(String line) {
        String[] lines = line.split(" ");
        this.dep = lines[1].toUpperCase();
    }

    @Override
    public void execute() throws IllegalDepartment {
        try {
            this.department = Role.valueOf(this.dep);
            switch (this.department) {
                case DEVELOPER -> departmentIT.get().showEmployees();
                case HR -> departmentHR.get().showEmployees();
                case MARKETING -> departmentMarketing.get().showEmployees();
                default -> throw new IllegalDepartment(this.department.toString());
            }
        } catch (Exception e) {
            throw new IllegalDepartment(this.dep);
        }
    }

}
