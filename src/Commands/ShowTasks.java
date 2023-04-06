package Commands;

import Employee.Role;
import Project.Project;
import Team.Team;

public class ShowTasks implements Command {

    private Integer teamId;
    private Integer projectId;

    public ShowTasks(String line) {
        this.teamId = Integer.parseInt(line.split(" ")[1]);
        this.projectId = Integer.parseInt(line.split(" ")[2]);
    }

    @Override
    public void execute() {
        Team team = departmentIT.get().getTeams().get(teamId);
        Project project = team.getProjectByID(projectId);

        project.showTasks();
    }
}
