package controller;

import model.Facility;
import service.Facility.FacilityService;
import service.Facility.IFacilityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = "/facility")

public class FacilityServlet extends HttpServlet {

    static List<Facility> facilityList = new ArrayList<>();
    private IFacilityService facilityService = new FacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveFacility(request, response);
                break;
            case "edit":
                updateFacility(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        facilityList = facilityService.findAll();

        request.setAttribute("facilityList", facilityList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("facility/listFacility.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int facilityId = Integer.parseInt(request.getParameter("facilityId"));
        String facilityName = request.getParameter("facilityName");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));

        Facility facility = new Facility(facilityId, facilityName, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId);
        facilityService.edit(facility);
        response.sendRedirect("/facility");
    }


    private void saveFacility(HttpServletRequest request, HttpServletResponse response) {
        int facilityId = Integer.parseInt(request.getParameter("facilityId"));
        String facilityName = request.getParameter("facilityName");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));

        Facility facility = new Facility(facilityId, facilityName, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId);

        facilityService.create(facility);

        RequestDispatcher dispatcher = request.getRequestDispatcher("facility/create.jsp");
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
                deleteFacility(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int facilityId = Integer.parseInt(request.getParameter("id"));
        try {
            facilityService.delete(facilityId);
            request.setAttribute("facilityList", facilityService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("facility/listFacility.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException throwables) {
            throwables.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int facilityId = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.findById(facilityId);
        RequestDispatcher dispatcher;
        if (facility == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("facility", facility);
            dispatcher = request.getRequestDispatcher("facility/edit.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("facility/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
