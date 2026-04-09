package EmployeeManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "0721";

    // 1. findAll()
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                int deptId = rs.getInt("dept_id");

                Employee emp = new Employee(id, name, salary, deptId);
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 2. findById()
    public Employee findById(int empId) {
        Employee emp = null;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM Employee WHERE emp_id = ?"
            );

            stmt.setInt(1, empId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                int deptId = rs.getInt("dept_id");

                emp = new Employee(id, name, salary, deptId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }

    // 3. create()
    public void create(Employee emp) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Employee (emp_id, name, salary, address_id, dept_id) VALUES (?, ?, ?, ?, ?)"
            );

            stmt.setInt(1, emp.getEmp_id());
            stmt.setString(2, emp.getName());
            stmt.setInt(3, emp.getSalary());
            stmt.setInt(4, 1);
            stmt.setInt(5, emp.getDept_id());

            stmt.executeUpdate();  // 🔥 THIS WAS MISSING

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. update()
    public void update(Employee emp) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Employee SET name = ?, salary = ?, dept_id = ? WHERE emp_id = ?"
            );

            stmt.setString(1, emp.getName());
            stmt.setInt(2, emp.getSalary());
            stmt.setInt(3, emp.getDept_id());
            stmt.setInt(4, emp.getEmp_id());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. delete()
    public void delete(int empId) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Employee WHERE emp_id = ?"
            );

            stmt.setInt(1, empId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MAIN METHOD (REQUIRED BY LAB)
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();

        // Create
        Employee emp = new Employee(101, "John", 5000, 1);
        repo.create(emp);

        // Read all
        System.out.println("All Employees:");
        List<Employee> list = repo.findAll();
        for (Employee e : list) {
            System.out.println(e.getEmp_id() + " " + e.getName());
        }

        // Read by ID
        System.out.println("Find by ID:");
        Employee e = repo.findById(101);
        if (e != null) {
            System.out.println(e.getName());
        }

        // Update
        emp.setName("John Updated");
        repo.update(emp);

        // Delete
        repo.delete(101);

        // Final check
        System.out.println("After Delete:");
        list = repo.findAll();
        for (Employee emp2 : list) {
            System.out.println(emp2.getEmp_id() + " " + emp2.getName());
        }
    }
}