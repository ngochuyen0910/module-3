package controller;

import model.Customer;
import service.Customer.CustomerService;
import service.Customer.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    static List<Customer> customerList = new ArrayList<>();
    private ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        customerList = customerService.findAll();

        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/listCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId= Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender= Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerMail = request.getParameter("customerMail");
        String customerAddress = request.getParameter("customerAddress");
        int customerTypeId= Integer.parseInt(request.getParameter("customerTypeId"));

        Customer customer= new Customer(customerId,customerName,customerBirthday,customerGender,customerIdCard,customerPhone,customerMail,customerAddress,customerTypeId);
        customerService.create(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
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
            default:
                findAll(request, response);
                break;
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
