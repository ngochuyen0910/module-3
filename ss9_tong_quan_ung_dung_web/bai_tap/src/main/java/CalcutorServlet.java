import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcutorServlet", urlPatterns = "/calculator")
public class CalcutorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount_percent"));
        float discount = (float) (price * discount_percent * 0.01);
        float total = price - discount;

        request.setAttribute("Description", description);
        request.setAttribute("Price", price);
        request.setAttribute("Discount_percent", discount_percent);
        request.setAttribute("Discount", discount);
        request.setAttribute("Total", total);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("calcutor.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
