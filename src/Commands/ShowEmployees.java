package Commands;

import Team.Team;

public class ShowEmployees implements Command{

    private String department;
    @Override
    public void execute() {
        switch (this.department) {
            case "IT" -> departmentIT.get().showEmployees();
            case "HR" -> departmentHR.get().showEmployees();
            case "Marketing" -> departmentMarketing.get().showEmployees();
        }
    }
}
