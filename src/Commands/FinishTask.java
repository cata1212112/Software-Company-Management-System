package Commands;

import Exceptions.TaskNotFound;
import Model.Project.*;

import java.util.Optional;

public class FinishTask implements Command{

    private int taskId;

    public FinishTask(String line) {
        String[] lines = line.split(" ");
        this.taskId = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() throws TaskNotFound {
        Optional<Project> projectOptional = departmentIT.get().getTeams().values().stream()
                .flatMap(team -> team.getProjects().stream())
                .filter(p -> p.getTasks().stream()
                        .anyMatch(t -> t.getTask_id() == this.taskId)).findFirst();

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Task task = project.getTasks().get(taskId);
            project.removeTask(task);
        } else {
            throw new TaskNotFound(this.taskId);
        }
    }
}
