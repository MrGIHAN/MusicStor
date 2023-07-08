package musician;

import java.io.IOException; 
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deletemusicianServlet")
public class deletemusicianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isTrue;
		
		imusicianDButil mu = new musicianDButil();
		isTrue = mu.deletemusician(id);
		
		if(isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("musicianinset.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<musicin> m_details = mu.getmusicianDetails(id);
			request.setAttribute("m_details", m_details);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useracc.jsp");
			dispatcher.forward(request, response);
		}
	}

}
