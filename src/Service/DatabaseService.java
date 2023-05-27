package Service;

import Model.Department.HR;
import Model.Department.IT;
import Model.Employee.*;
import Model.Department.Marketing;
import Model.Project.Project;
import Model.Project.Task;
import Repositories.EmployeeRepository;
import Repositories.ProjectRepository;
import Repositories.TaskRepository;
import Repositories.TeamRepository;
import Model.Team.Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DatabaseService {
    public static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5433/proiectPAO", "cata", "");
        } catch (SQLException e) {
            System.out.println("Could not establish connection! " + e.getMessage());
            System.exit(0);
        }
    }

    private DatabaseService() {

    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void loadDatabase() {
        System.out.println("Loading database...");

        ArrayList<Team> allTeams = TeamRepository.getInstance().read();

        for (Team t : allTeams) {
            if (t.getDep().equals(Role.DEVELOPER)) {
                IT.getInstance().addTeamNODB(t);
            } else if (t.getDep().equals(Role.HR)) {
                HR.getInstance().addTeamNODB(t);
            } else {
                Marketing.getInstance().addTeamNODB(t);
            }
        }

        ArrayList<Employee> allEmployees = EmployeeRepository.getInstance().read();

        for (Employee emp : allEmployees) {
            if (emp instanceof HumanResources) {
                Optional<Team> t = HR.getInstance().getTeams().values().stream().filter(x -> x.getId() == emp.getTeam_id()).findFirst();
                t.ifPresent(team -> team.addEmployeeNODB(emp));
            } else if (emp instanceof MarketingEmp) {
                Optional<Team> t = Marketing.getInstance().getTeams().values().stream().filter(x -> x.getId() == emp.getTeam_id()).findFirst();
                t.ifPresent(team -> team.addEmployeeNODB(emp));
            } else if (emp instanceof Developer) {
                Optional<Team> t = IT.getInstance().getTeams().values().stream().filter(x -> x.getId() == emp.getTeam_id()).findFirst();
                t.ifPresent(team -> team.addEmployeeNODB(emp));
            }
        }

        ArrayList<Project> allProjects = ProjectRepository.getInstance().read();

        for (Project pr : allProjects) {
            IT.getInstance().getTeams().get(pr.getTeam_id()).addProjectnodb(pr);
        }

        ArrayList<Task> allTasks = TaskRepository.getInstance().read();

        for (Task task : allTasks) {
            Optional<Team> t = IT.getInstance().getTeams().values().stream().filter(x -> x.getProjects().stream().anyMatch(y -> y.getProject_id() == task.getProjectID())).findFirst();
            t.get().getProjects().stream().filter(x -> x.getProject_id() == task.getProjectID()).findFirst().get().addTaskToProjectNODB(task);
        }

        System.out.println("Done");
    }
}
