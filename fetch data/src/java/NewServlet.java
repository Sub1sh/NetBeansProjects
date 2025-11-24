import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student Table</title></head><body>");
        out.println("<h2>Students List</h2>");
        out.println("<table border='1' cellpadding='8'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Salary</th><th>Gender</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/swastik",
                    "root",
                    "Root"); 

            String sql = "SELECT * FROM std";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("Id") + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getString("Salary") + "</td>");
                out.println("<td>" + rs.getString("Gender") + "</td>");
                out.println("</tr>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}