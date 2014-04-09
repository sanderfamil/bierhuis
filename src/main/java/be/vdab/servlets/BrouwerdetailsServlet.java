package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("brouwer", brouwerService.read(Long.parseLong(request.getParameter("brouwerId"))));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
