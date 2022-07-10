package controller;

import model.BenhAn;
import model.BenhNhan;
import service.BenhAn.BenhAnService;
import service.BenhAn.IBenhAnService;
import service.BenhNhan.BenhNhanService;
import service.BenhNhan.IBenhNhanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhNhanServlet", urlPatterns = "/hospital")
public class BenhNhanServlet extends HttpServlet {
    private IBenhNhanService benhNhanService = new BenhNhanService();
    private IBenhAnService benhAnService = new BenhAnService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                updateBenhNhan(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }

    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        List<BenhAn> benhAnList = benhAnService.findAll();

        request.setAttribute("benhNhanList", benhNhanList);
        request.setAttribute("benhAnList", benhAnList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/hospital/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBenhNhan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int stt = Integer.parseInt(request.getParameter("stt"));
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDoNhapVien = request.getParameter("lyDoNhapVien");

        BenhNhan benhNhan = new BenhNhan(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        benhNhanService.edit(benhNhan);
        response.sendRedirect("/hospital");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteBenhNhan(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void deleteBenhNhan(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);

        int stt = Integer.parseInt(request.getParameter("id"));
        try {
            benhNhanService.delete(stt);
            request.setAttribute("benhNhanList", benhNhanService.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/hospital/list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);

        int stt = Integer.parseInt(request.getParameter("id"));
        BenhNhan benhNhan = benhNhanService.findById(stt);
        RequestDispatcher dispatcher;
        if (benhNhan == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("benhNhan", benhNhan);
            dispatcher = request.getRequestDispatcher("view/hospital/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
