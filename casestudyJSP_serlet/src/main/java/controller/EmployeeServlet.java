package controller;

import model.Employee;
import service.Employee.EmployeeService;
import service.Employee.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    static List<Employee> employeeList = new ArrayList<>();
    private IEmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        try {
            request.setAttribute("employee", employeeService.findById(employeeId));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/view.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
        employeeService.edit(employee);
        response.sendRedirect("/employee");
    }

    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
        employeeService.create(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        try {
            employeeService.delete(employeeId);
            request.setAttribute("employeeList", employeeService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/listEmployee.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeService.findById(employeeId);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        employeeList = employeeService.findAll();

        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/listEmployee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
