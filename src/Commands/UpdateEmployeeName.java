package Commands;

import Exceptions.*;
import Model.Employee.Employee;
import Model.Project.Project;
import Model.Project.Task;
import Repositories.EmployeeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UpdateEmployeeName implements Command{

    private int employeeID;
    private String newName;

    public UpdateEmployeeName(String line) {
        String[] lines = line.split(" ");
        this.employeeID = Integer.parseInt(lines[1]);
        this.newName = lines[2];
    }

    @Override
    public void execute() throws EmployeeNotFound, TaskNotFound, IllegalPosition, TeamNotFound, ProjectNotFound, IllegalDepartment, TeamHasEmployees, ProjectHasTasks, NameAlreadyInUse {
        Optional<Employee> employeeOptional1 = departmentIT.get().getEmployees().stream().filter(x -> x.getEmployee_id() == this.employeeID).findFirst();

        Optional<Employee> employeeOptional2 = departmentHR.get().getEmployees().stream().filter(x -> x.getEmployee_id() == this.employeeID).findFirst();

        Optional<Employee> employeeOptional3 = departmentMarketing.get().getEmployees().stream().filter(x -> x.getEmployee_id() == this.employeeID).findFirst();
        if (!employeeOptional1.isPresent() && !employeeOptional2.isPresent() && !employeeOptional3.isPresent()) {
            throw new EmployeeNotFound(this.employeeID);
        } else if (employeeOptional2.isPresent()){
           employeeOptional2.get().setName(this.newName);
           EmployeeRepository.getInstance().update(employeeOptional2.get());
        } else if (employeeOptional3.isPresent()) {
            employeeOptional3.get().setName(this.newName);
            EmployeeRepository.getInstance().update(employeeOptional3.get());
        } else {
            employeeOptional1.get().setName(this.newName);
            EmployeeRepository.getInstance().update(employeeOptional1.get());
        }
    }
}
