package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employee;
import code.ConnectionManager;
public class EmployeeDao{

    public int addEmployee(Employee e) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  ( employeeId ,employeeName , employeeRole, employeeSalary) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

       
      try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","examly");
     
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT_USERS_SQL)) {                preparedStatement.setInt(1,e.getEmployeeId());
            preparedStatement.setString(2,e.getEmployeeName());
            preparedStatement.setString(3,e.getEmployeeRole());
            preparedStatement.setInt(4,e.getEmployeeSalary());
            

        // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}




            