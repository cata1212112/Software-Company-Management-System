package Commands;

import Model.Employee.Employee;
import Exceptions.*;
import Model.Project.*;
import Repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeleteEmployee implements Command{
    private int employeeId;

    public DeleteEmployee(String line) {
        String[] lines = line.split(" ");
        this.employeeId = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() throws EmployeeNotFound, TaskNotFound, IllegalPosition, TeamNotFound, ProjectNotFound, IllegalDepartment, TeamHasEmployees, ProjectHasTasks {
        Optional<Employee> employeeOptional1 = departmentIT.get().getEmployees().stream().filter(x -> x.getEmployee_id() == this.employeeId).findFirst();

        Optional<Employee> employeeOptional2 = departmentHR.get().getEmployees().stream().filter(x -> x.getEmployee_id() == this.employeeId).findFirst();

        Optional<Employee> employeeOptional3 = departmentMarketing.get().getEmployees().stream().filter(x -> x.getEmployee_id() == this.employeeId).findFirst();
        if (!employeeOptional1.isPresent() && !employeeOptional2.isPresent() && !employeeOptional3.isPresent()) {
            throw new EmployeeNotFound(this.employeeId);
        } else if (employeeOptional2.isPresent()){
            EmployeeRepository.getInstance().delete(this.employeeId);
            departmentHR.get().getEmployees().removeIf(x -> x.getEmployee_id() == this.employeeId);
        } else if (employeeOptional3.isPresent()) {
            EmployeeRepository.getInstance().delete(this.employeeId);
            departmentMarketing.get().getEmployees().removeIf(x -> x.getEmployee_id() == this.employeeId);
        } else {
            List<Project> projects = departmentIT.get().getTeams().values().stream().filter(x -> x.checkEmployee(this.employeeId)).findFirst().get().getProjects();
            projects = projects.stream().filter(x -> x.getTasks().stream().anyMatch(y -> y.getAssignedEmployeeID() == this.employeeId)).collect(Collectors.toList());
            for (Project pr : projects) {
                for (Task tsk : pr.getTasks()) {
                    tsk.setAssignedEmployeeID(-1);
                }
            }
            departmentIT.get().getTeams().values().stream().filter(x -> x.checkEmployee(this.employeeId)).forEach(x -> x.removeEmployee(this.employeeId));
            departmentIT.get().getEmployees().removeIf(x -> x.getEmployee_id() == this.employeeId);
            EmployeeRepository.getInstance().delete(this.employeeId);


        }
    }
}
