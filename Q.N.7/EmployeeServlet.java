import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type for browser
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Hardcoded employee details (for demo)
        String empName = "John Doe";
        int empId = 101;
        String empDepartment = "IT";
        double empSalary = 55000.50;

        // HTML response
        out.println("<html>");
        out.println("<head><title>Employee Details</title></head>");
        out.println("<body style='font-family:Arial; margin:20px;'>");
        out.println("<h2>Employee Details</h2>");
        out.println("<table border='1' cellpadding='10' cellspacing='0'>");
        out.println("<tr><th>Employee ID</th><td>" + empId + "</td></tr>");
        out.println("<tr><th>Name</th><td>" + empName + "</td></tr>");
        out.println("<tr><th>Department</th><td>" + empDepartment + "</td></tr>");
        out.println("<tr><th>Salary</th><td>$" + empSalary + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
