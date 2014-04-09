package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.services.BrouwerService;

/**
 * Servlet implementation class BrouwerdetailsServlet
 */
@WebServlet("/brouwerdetail.htm")
public class BrouwerdetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/brouwerdetail.jsp";
	private transient BrouwerService brouwerService = new BrouwerService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try{
		HttpSession session = request.getSession(false);
		if(session!=null){
			request.setAttribute("mandje", session.getAttribute("mandje"));
		}
		request.setAttribute("brouwer", brouwerService.readBrouwerAndBier(Long.parseLong(request.getParameter("brouwerId"))));
		
		}
		catch(NumberFormatException ex){
			request.setAttribute("fout","BrouwerId mag niet leeg zijn. Mag enkel cijfers bevatten.");
			
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
