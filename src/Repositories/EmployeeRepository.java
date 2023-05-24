package Repositories;

import CRUD.CRUDInterface;
import Employee.*;
import Service.DatabaseService;

import java.sql.Connection;
import java.util.ArrayList;

public class EmployeeRepository implements CRUDInterface<Employee> {

    private static EmployeeRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private EmployeeRepository() {

    }

    public EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public Employee create(Employee Entity) {
        return null;
    }

    @Override
    public ArrayList<Employee> read() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Employee update(Employee Entity) {
        return null;
    }
}
