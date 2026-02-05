import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Hardcoded employee details
        String empName = "Nabaraj";
        int empId = 101;
        String empDepartment = "IT";
        double empSalary = 55000.50;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Employee Details</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background: #f8f9fa; }");
        out.println("h2 { color: navy; }");
        out.println("table { border-collapse: collapse; width: 50%; margin: auto; }");
        out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
        out.println("th { background-color: #007bff; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("</style></head>");
        out.println("<body>");
        out.println("<h2>Employee Details</h2>");
        out.println("<table>");
        out.println("<tr><th>Employee ID</th><td>" + empId + "</td></tr>");
        out.println("<tr><th>Name</th><td>" + empName + "</td></tr>");
        out.println("<tr><th>Department</th><td>" + empDepartment + "</td></tr>");
        out.println("<tr><th>Salary</th><td>$" + empSalary + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}