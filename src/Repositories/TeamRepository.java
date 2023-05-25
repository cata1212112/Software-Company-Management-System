package Repositories;

import CRUD.CRUDInterface;
import Service.DatabaseService;
import Team.Team;

import java.sql.*;
import java.util.ArrayList;

public class TeamRepository implements CRUDInterface<Team> {

    private static TeamRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private TeamRepository() {

    }

    public static TeamRepository getInstance() {
        if (instance == null) {
            instance = new TeamRepository();
        }
        return instance;
    }

    @Override
    public Team create(Team Entity) {
        try {
            String query = "INSERT INTO teams (team_id, name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Entity.getId());
            stmt.setString(2, Entity.getName());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Entity;
    }

    @Override
    public ArrayList<Team> read() {
        ArrayList<Team> arr = new ArrayList<>();
        try {
            String query = "SELECT * FROM teams";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                arr.add(new Team(res.getInt("team_id"), res.getString("name")));
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM teams WHERE team_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Team update(Team Entity) {
        return null;
    }
}
