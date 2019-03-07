package BackEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import WeatherReader.Weather;
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
		String detailCity= request.getParameter("detailCity");
		String page = "/result.jsp";
		HttpSession session = request.getSession();	
		String username = (String)session.getAttribute("Account");
		if(city != null) {
			choice += "city";
			try {
				Weather city2 = weatherRequest.getByName(city);
				validation.addSearch(username, city2.getCity());
				System.out.println(city2);
				session.setAttribute("city", city2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("city", null);
			}
		}
		else if(latitude != null || longitude !=null) {
			choice +="location";
			Weather city1;
			try {
				city1 = weatherRequest.getByCor(latitude, longitude);
				String loc = "(" + String.valueOf(city1.getLatitude())+"," +String.valueOf(city1.getLongitude())+")";
				validation.addSearch(username, loc);
				session.setAttribute("city", city1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Display != null) {
			choice += "displayAll";
		}
		if(detailCity!= null) {
			page = "/details.jsp";
		}
		System.out.println(choice);
		request.setAttribute("choice", choice);
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
		dispatch.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
