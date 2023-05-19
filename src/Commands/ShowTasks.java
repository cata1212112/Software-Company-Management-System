package Commands;

import Employee.Role;
import Project.Project;
import Team.Team;

import java.util.Optional;

public class ShowTasks implements Command {
    private Integer projectId;

    public ShowTasks(String line) {
        this.projectId = Integer.parseInt(line.split(" ")[1]);
    }

    @Override
    public void execute() {

        Optional<Team> teamOptional = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getProjects().stream().anyMatch(pr -> pr.getProject_id() == this.projectId)).findFirst();

        if (teamOptional.isPresent()) {
            Project project = teamOptional.get().getProjectByID(projectId);
            project.showTasks();
        }
    }
}
