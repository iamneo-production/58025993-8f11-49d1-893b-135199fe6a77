package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class servlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;

    public void init() {
    	employeeDao = new EmployeeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	int registerEmployeeId = 0;
    	
        int employeeId  = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String employeeRole = request.getParameter("employeeRole");
        double employeeSalary = request.getParameter(" employeeSalary");
        

        Employee e = new Employee();
        e.setEmployeeId(employeeId);
        e.setEmployeeName(employeeName);
        e.setEmployeeRole(employeeRole);
        e.setEmployeeSalary(employeeSalary);
        

        try {
        	registerEmployeeId = employeeDao.addEmployee(e);
        } catch (Exception et) {
            et.printStackTrace();
        }
        if(registerEmployeeId > 0) {
        request.setAttribute("employeeId",e.getEmployeeId());
          request.setAttribute("employeeName",e.getEmployeeName());
          request.setAttribute("employeeRole",e.getEmployeeRole());
          request.setAttribute("employeeSalary", e.getEmployeeSalary());
         

          RequestDispatcher requestDispatcher = request.getRequestDispatcher("employeeDetails.jsp");
          requestDispatcher.forward(request, response);
        }
    }
}

