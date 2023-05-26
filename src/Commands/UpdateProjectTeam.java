package Commands;

import Exceptions.*;
import Model.Project.Project;
import Model.Team.Team;

import java.util.Optional;

public class UpdateProjectTeam implements Command{
    private int projectID;
    private int newTeadmID;

    public UpdateProjectTeam(String line) {
        String[] lines = line.split(" ");
        this.projectID = Integer.parseInt(lines[1]);
        this.newTeadmID = Integer.parseInt(lines[2]);
    }

    @Override
    public void execute() throws EmployeeNotFound, TaskNotFound, IllegalPosition, TeamNotFound, ProjectNotFound, IllegalDepartment, TeamHasEmployees, ProjectHasTasks, NameAlreadyInUse, EmailAlreadyInUse, ProjectHasAssignedTasks {
        Team teamNew = departmentIT.get().getTeams().get(this.newTeadmID);
        if (teamNew == null) {
            throw new TeamNotFound(this.newTeadmID);
        } else {
            Optional<Team> team = departmentIT.get().getTeams().values().stream().filter(x -> x.getProjects().stream().anyMatch(y -> y.getProject_id()==this.projectID)).findFirst();
            if (team.isPresent()) {
                Project pr = team.get().getProjectByID(this.projectID);
                long cnt = pr.getTasks().stream().filter(x -> x.isAssigned()).count();
                if (cnt > 0) {
                    throw new ProjectHasAssignedTasks();
                } else {
                    team.get().getProjects().removeIf(x -> x.getTeam_id()==pr.getTeam_id());
                    pr.setTeam_id(this.newTeadmID);
                    teamNew.addProjectnodb(pr);
                }
            } else {
                throw new ProjectNotFound(this.projectID);
            }
        }


    }
}
