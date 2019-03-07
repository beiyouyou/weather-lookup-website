package BackEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login_manage")
public class login_manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login_manage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String page = "/login.jsp";	//starting from here, problem//username is not equal to beiyouzh
		if(!validation.validateUsername(username)) {
			request.setAttribute("errorMSG", "Username does not exist.");
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
			dispatch.forward(request, response);
		}
		else if(!validation.validatePassword(username, password)) {
			request.setAttribute("errorMSG", "Incorrect Password");
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
			dispatch.forward(request, response);
		}
		else {
			page = "/index.jsp";
			request.getSession().setAttribute("Account", username);
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
		dispatch.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
