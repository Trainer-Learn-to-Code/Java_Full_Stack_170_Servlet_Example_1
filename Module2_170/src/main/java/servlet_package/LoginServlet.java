package servlet_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username.isEmpty() && password.isEmpty())
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.html");
			requestDispatcher.include(request, response);
		}
			
		
		
		if(username.equals("adminuser") && password.equals("admin123")) {
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.html");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/login_page.html");
			requestDispatcher.include(request, response);
		}
		

		
		
//		printWriter.println("Hello "+username);
//		printWriter.println("Password"+password);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
