package musician;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//desige

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		String username = request.getParameter("userid");
		String password = request.getParameter("userpass");
		
		try {
			imusicianDButil mu = new musicianDButil();	
		List<musicin> musdetails = mu.validate(username, password);
		request.setAttribute("m_details", musdetails);
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher("useracc.jsp");
		dis.forward(request, response);
		
	}

}
