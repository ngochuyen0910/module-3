package controller;

import model.Customer;

import model.CustomerType;
import service.customer.CustomerService;
import service.customer.ICustomerService;
import service.customer_type.CustomerTypeService;
import service.customer_type.ICustomerTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

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
            case "search":
                searchCustomer(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        try {
            request.setAttribute("customer", customerService.findById(customerId));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/view.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/listCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerMail = request.getParameter("customerMail");
        String customerAddress = request.getParameter("customerAddress");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));

        Customer customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone,
                customerMail, customerAddress, customerTypeId);
        customerService.edit(customer);
        response.sendRedirect("/customer");
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerMail = request.getParameter("customerMail");
        String customerAddress = request.getParameter("customerAddress");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));

        Customer customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone,
                customerMail, customerAddress, customerTypeId);
        customerService.create(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
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
                deleteCustomer(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);

        int customerId = Integer.parseInt(request.getParameter("id"));
        try {
            customerService.delete(customerId);
            request.setAttribute("customerList", customerService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/listCustomer.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(customerId);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
