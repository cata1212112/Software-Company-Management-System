package Repositories;

import CRUD.CRUDInterface;
import Model.Employee.Role;
import Model.Project.*;
import Model.Team.Team;
import Service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;

public class TaskRepository implements CRUDInterface<Task> {

    private static TaskRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private TaskRepository() {

    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    @Override
    public Task create(Task Entity) {
        try {
            String query = "INSERT INTO tasks (task_id, description, priority, is_assigned, project_id, assigned_employee_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Entity.getTask_id());
            stmt.setString(2, Entity.getDescription());
            stmt.setInt(3, Entity.getPriority());
            stmt.setBoolean(4, Entity.isAssigned());
            stmt.setInt(5, Entity.getProjectID());
            stmt.setObject(6, Entity.getAssignedEmployeeID());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Entity;
    }

    @Override
    public ArrayList<Task> read() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            String query = "SELECT * FROM tasks";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                tasks.add(new Task(res.getInt("task_id"), res.getString("description"), res.getInt("priority"), res.getBoolean("is_assigned"), res.getInt("project_id"), res.getInt("assigned_employee_id")));
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tasks;
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM tasks WHERE task_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Task update(Task Entity) {
        try {
            String query = "UPDATE tasks SET is_assigned = ?, assigned_employee_id = ? WHERE task_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setBoolean(1, Entity.isAssigned());
            stmt.setObject(2, Entity.getAssignedEmployeeID());
            stmt.setInt(3, Entity.getTask_id());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Entity;
    }
}
