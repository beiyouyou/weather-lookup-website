package backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Backend
 */
@WebServlet("/Backend")
public class Backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Backend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("cityname");
		String latitude = request.getParameter("Latitude");
		String longitude = request.getParameter("Longitude");
		String Display = request.getParameter("Display");
		String choice = "";
		if(city != null) {
			choice += "city";
		}
		else if(latitude != null || longitude !=null) {
			choice +="location";
		}
		else if(Display != null) {
			choice += "displayAll";
		}
		System.out.println(choice);
		request.setAttribute("choice", choice);
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/result.jsp");
		dispatch.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
