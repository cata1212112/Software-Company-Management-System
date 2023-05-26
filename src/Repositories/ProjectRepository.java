package Repositories;

import CRUD.CRUDInterface;
import Model.Project.*;
import Service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;

public class ProjectRepository implements CRUDInterface<Project> {

    private static ProjectRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private ProjectRepository() {

    }

    public static ProjectRepository getInstance() {
        if (instance == null) {
            instance = new ProjectRepository();
        }
        return instance;
    }

    @Override
    public Project create(Project Entity) {
        try {
            String query = "INSERT INTO projects (project_id, is_assigned, name, team_id, deadline, description) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Entity.getProject_id());
            stmt.setBoolean(2, Entity.isAssigned());
            stmt.setString(3, Entity.getName());
            stmt.setInt(4, Entity.getTeam_id());
            stmt.setDate(5, new java.sql.Date(Entity.getDeadline().getTime()));
            stmt.setString(6, Entity.getDescription());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Entity;
    }

    @Override
    public ArrayList<Project> read() {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            String query = "SELECT * FROM projects";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                projects.add(new Project(res.getInt("project_id"), res.getBoolean("is_assigned"), res.getString("name"), res.getInt("team_id"), new java.util.Date(res.getDate("deadline").getTime()), res.getString("description")));
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return projects;
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM projects WHERE project_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Project update(Project Entity) {
        try {
            String query = "UPDATE projects SET team_id = ? WHERE project_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Entity.getTeam_id());
            stmt.setInt(2, Entity.getProject_id());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Entity;
    }
}
