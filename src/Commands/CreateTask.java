package Commands;

import Exceptions.ProjectNotFound;
import Model.Project.*;
import Model.Team.Team;

import java.util.Optional;

public class CreateTask implements Command {

    private String description;
    private int priority;
    private int project_id;

    public CreateTask(String line) {
        String lines[] = line.split(" ");
        this.priority = Integer.parseInt(lines[1]);
        this.project_id = Integer.parseInt(lines[2]);
        StringBuilder aux = new StringBuilder();
        for (int i=3; i< lines.length; i++) {
            aux.append(lines[i]).append(" ");
        }
        this.description = aux.toString();
    }

    @Override
    public void execute() throws ProjectNotFound {
            Optional<Team> teamOptional = departmentIT.get().getTeams().values().stream()
                    .filter(t -> t.getProjects().stream().anyMatch(pr -> pr.getProject_id() == this.project_id)).findFirst();

            if (teamOptional.isPresent()) {
                Project project = teamOptional.get().getProjectByID(this.project_id);
                project.addTaskToProject(new Task(this.description, this.priority, this.project_id));
            } else {
                throw new ProjectNotFound(this.project_id);

            }
    }
}
