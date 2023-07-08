package musician;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/musicianinsert")
public class musicianinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		imusicianDButil mu = new musicianDButil();
		isTrue = mu.insertmusician(name, email, username, password);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("useracc.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis1 = request.getRequestDispatcher("mucisianinsert.jsp");
			dis1.forward(request, response);
		}
		
	}

}
