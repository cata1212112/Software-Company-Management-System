package Commands;

import Exceptions.EmployeeNotFound;
import Exceptions.TaskNotFound;
import Model.Project.*;
import Model.Team.Team;

import java.util.Optional;

public class AddEmployeeToTask implements Command {

    private int employeeId;
    private int taskId;

    public AddEmployeeToTask(String line) {
        String[] lines = line.split(" ");
        this.employeeId = Integer.parseInt(lines[1]);
        this.taskId = Integer.parseInt(lines[2]);
    }

    @Override
    public void execute() throws EmployeeNotFound, TaskNotFound {
        Optional<Team> teamOptional = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getEmployees().values().stream().anyMatch(e -> e.getEmployee_id() == this.employeeId)).findFirst();

        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();

            Optional<Task> taskOptional = team.getProjects().stream()
                    .flatMap(project -> project.getTasks().stream())
                    .filter(task -> task.getTask_id() == this.taskId)
                    .findFirst();

            if (taskOptional.isPresent()) {
                Task task = taskOptional.get();
                task.setAssignedEmployeeID(employeeId);
            } else {
                throw new TaskNotFound(this.taskId);
            }

        } else {
            throw new EmployeeNotFound(this.employeeId);
        }
    }
}