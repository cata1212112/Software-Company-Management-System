import Employee.Employee;

import java.util.Date;

public class Task {
    private String description;
    private Date deadline;
    private Employee assignedEmployee;

    public Task(String description, Date deadline, Employee assignedEmployee) {
        this.description = description;
        this.deadline = deadline;
        this.assignedEmployee = assignedEmployee;
    }
}
