package Commands;

import Exceptions.TeamNotFound;
import Model.Project.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateProject implements Command{
    private String name;
    private Date deadline;
    private String description;
    private int team_id;

    public CreateProject(String line) throws ParseException {
        String[] lines = line.split(" ");
        this.name = lines[1];
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.deadline = inputFormat.parse(lines[2]);
        this.team_id = Integer.parseInt(lines[3]);
        StringBuilder aux = new StringBuilder();
        for (int i=4; i< lines.length; i++) {
            aux.append(lines[i]).append(" ");
        }
        this.description = aux.toString();
    }

    @Override
    public void execute() throws TeamNotFound {
        try {
            departmentIT.get().getTeams().get(team_id).addProject(new Project(this.name, this.deadline, this.description, this.team_id));
        } catch (NullPointerException e) {
            throw new TeamNotFound(this.team_id);
        }
    }
}
