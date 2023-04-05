import Team.Team;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    private String name;
    Team team;
    private Date deadline;
    private String description;

    private ArrayList<Task> tasks;

    public Project() {
        tasks = new ArrayList<>();
    }
    public Project(String name, Team team, Date deadline, String description) {
        this.name = name;
        this.team = team;
        this.deadline = deadline;
        this.description = description;
    }
}
