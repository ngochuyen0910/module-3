package controller;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Facility;
import service.contract.ContractService;
import service.contract.IContractService;
import service.customer.CustomerService;
import service.customer.ICustomerService;
import service.employee.EmployeeService;
import service.employee.IEmployeeService;
import service.facility.FacilityService;
import service.facility.IFacilityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    private IContractService contractService = new ContractService();
    private IEmployeeService employeeService = new EmployeeService();
    private ICustomerService customerService = new CustomerService();
    private IFacilityService facilityService= new FacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveContract(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<Facility> facilityList = facilityService.findAll();

        request.setAttribute("contractList", contractList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("facilityList", facilityList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/listContract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveContract(HttpServletRequest request, HttpServletResponse response) {

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
            default:
                findAll(request, response);
                break;
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
    }
}

