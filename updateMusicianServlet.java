package musician;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateMusicianServlet")
public class updateMusicianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
	
		boolean isTrue;
		
		imusicianDButil mu = new musicianDButil();
		isTrue = mu.updatemusician(id, name, email, username, password);
		
		if(isTrue == true) {
			
			List<musicin> m_details = mu.getmusicianDetails(id);
			request.setAttribute("m_details",m_details );
			
			RequestDispatcher dis = request.getRequestDispatcher("useracc.jsp");
			dis.forward(request, response);
		}
		else {
			List<musicin> m_details = mu.getmusicianDetails(id);
			request.setAttribute("m_details",m_details );
			
			RequestDispatcher dis = request.getRequestDispatcher("useracc.jsp");
			dis.forward(request, response);
		}
		
	}

}
