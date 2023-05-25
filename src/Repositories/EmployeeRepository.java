package Repositories;

import CRUD.CRUDInterface;
import Employee.*;
import Service.DatabaseService;
import Team.Team;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository implements CRUDInterface<Employee> {

    private static EmployeeRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private EmployeeRepository() {

    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public Employee create(Employee Entity) {
        try {
            String query = "INSERT INTO employees (employee_id, name, email, team_id, salary, role, department, prLang) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Entity.getEmployee_id());
            stmt.setString(2, Entity.getName());
            stmt.setString(3, Entity.getEmail());
            stmt.setInt(4, Entity.getTeam_id());
            stmt.setDouble(5, Entity.getSalary());
            stmt.setString(6, Entity.getRole().toString());
            stmt.setString(7, Entity.getDep());

            ArrayList<String> arr = Entity.getPrLag();
            if (arr == null) {
                stmt.setArray(8, null);
            } else {
                stmt.setArray(8, conn.createArrayOf("varchar", arr.toArray()));
            }
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Entity;
    }

    @Override
    public ArrayList<Employee> read() {

        ArrayList<Employee> arr = new ArrayList<>();
        try {
            String query = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("employee_id");
                String name = res.getString("name");
                String email = res.getString("email");
                int teamID = res.getInt("team_id");
                float salary = res.getFloat("salary");
                String role = res.getString("role");
                String dep = res.getString("department");

                ArrayList<String> prLang = new ArrayList<>();
                Array hobbiesArray = res.getArray("prLang");
                if (hobbiesArray != null) {
                    ResultSet hobbiesResult = hobbiesArray.getResultSet();
                    while (hobbiesResult.next()) {
                        prLang.add(hobbiesResult.getString(2));
                    }
                    hobbiesResult.close();
                }

                if (dep.equals("HR")) {
                    arr.add(new HumanResources(id, name, email, teamID, salary, Role.Position.valueOf(role)));
                } else if (dep.equals("Marketing")) {
                    arr.add(new Marketing(id, name, email, teamID, salary, Role.Position.valueOf(role)));
                } else {
                    arr.add(new Developer(id, name, email, teamID, salary, Role.Position.valueOf(role), prLang));

                }

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
            String query = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Employee update(Employee Entity) {
        return null;
    }
}
