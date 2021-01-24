package assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("Basic Servlet initialised!!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().println("Welcome To Servlet!!!");
		System.out.println("basic servlet rendered!!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Basic servlet destroyed");
	}

}
