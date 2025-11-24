import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/CookiesServletTwo")
public class CookiesServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CookiesServletTwo() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try{
		       response.setContentType("text/html");
		       PrintWriter pwriter = response.getWriter();
		 
		       //Reading cookies
		       Cookie c[]=request.getCookies(); 
		       //Displaying User name value from cookie
		       pwriter.print("Name: "+c[0].getValue()); 
		       //Displaying user password value from cookie
		       pwriter.print("Password: "+c[1].getValue());
		 
		       pwriter.close();
		    }catch(Exception exp){
		       System.out.println(exp);
		     }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}