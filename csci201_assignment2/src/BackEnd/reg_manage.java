package BackEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg_manage")
public class reg_manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reg_manage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String Cpassword = request.getParameter("Cpassword");
		String page = "/register.jsp";	//starting from here, problem//username is not equal to beiyouzh
		if(validation.validateUsername(username)) {
			request.setAttribute("RerrorMSG", "This username is already taken");
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
			dispatch.forward(request, response);
		}
		else if(!password.equals(Cpassword)) {
			request.setAttribute("RerrorMSG", "The passwords do not match");
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
			dispatch.forward(request, response);
		}
		else {
			page = "/index.jsp";
			validation.addUser(username, password);
			request.getSession().setAttribute("Account", username);
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
		dispatch.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
