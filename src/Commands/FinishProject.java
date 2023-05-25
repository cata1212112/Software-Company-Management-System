package Commands;

import Exceptions.ProjectHasTasks;
import Exceptions.ProjectNotFound;
import Model.Project.Project;
import Model.Team.Team;

import java.util.Optional;

public class FinishProject implements Command{
    private int projectId;

    public FinishProject(String line) {
        String[] lines = line.split(" ");
        this.projectId = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() throws ProjectNotFound, ProjectHasTasks {
        Optional<Team> teamOptional = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getProjects().stream().anyMatch(p -> p.getProject_id() == this.projectId)).findFirst();

        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            Project project = team.getProjectByID(projectId);
            if (project.getTasks().size() > 0) {
                throw new ProjectHasTasks("Project " + this.projectId + " has tasks!");
            }
            team.removeProject(project);
        } else  {
            throw new ProjectNotFound(this.projectId);
        }
    }
}

