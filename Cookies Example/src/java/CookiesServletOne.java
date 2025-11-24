import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/CookiesServletOne")
public class CookiesServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CookiesServletOne() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	          response.setContentType("text/html");
	          PrintWriter pwriter = response.getWriter();

	          String name = request.getParameter("userName");
	          String password = request.getParameter("userPassword");
	          pwriter.print("Hello "+name);
	          pwriter.print("Your Password is: "+password);

	          //Creating two cookies
	          Cookie c1=new Cookie("userName",name);
	          Cookie c2=new Cookie("userPassword",password);

	          //Adding the cookies to response header
	          response.addCookie(c1);
	          response.addCookie(c2);
	          pwriter.print("<br><a href='CookiesServletTwo'>View Details</a>");
	          pwriter.close();
	   }catch(Exception exp){
	       System.out.println(exp);
	   }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
