package Commands;

import Exceptions.TeamNotFound;
import Model.Team.Team;

public class ShowProjects implements Command{

    private Integer teamId;

    public ShowProjects(String line) {
        String[] lines = line.split(" ");
        this.teamId = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() throws TeamNotFound {
        try {
            Team team = departmentIT.get().getTeams().get(teamId);

            team.showProjects();
        } catch (NullPointerException e) {
            throw new TeamNotFound(this.teamId);
        }
    }

}
