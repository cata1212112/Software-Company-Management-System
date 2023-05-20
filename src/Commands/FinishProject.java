package Commands;

import Exceptions.ProjectNotFound;
import Project.Project;
import Project.Task;
import Team.Team;

import java.awt.color.ProfileDataException;
import java.util.Optional;

public class FinishProject implements Command{
    private int projectId;

    public FinishProject(String line) {
        String[] lines = line.split(" ");
        this.projectId = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() throws ProjectNotFound {
        Optional<Team> teamOptional = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getProjects().stream().anyMatch(p -> p.getProject_id() == this.projectId)).findFirst();

        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            Project project = team.getProjectByID(projectId);
            team.removeProject(project);
        } else  {
            throw new ProjectNotFound(this.projectId);
        }
    }
}

