package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.services.BierService;

/**
 * Servlet implementation class BierServlet
 */
@WebServlet("/bier.htm")
public class BierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/bier.jsp";
	private static final String REDIRECT_URL = "%s/winkelwagen.htm";
	private transient final BierService bierService = new BierService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
		HttpSession session = request.getSession(false);
		Long bierId=Long.parseLong(request.getParameter("bierId"));
		if(session!=null){
			request.setAttribute("mandje", session.getAttribute("mandje"));
			@SuppressWarnings("unchecked")
			Map<Long, Integer> mandje = (Map<Long, Integer>)session.getAttribute("mandje");
			if(mandje.containsKey(bierId)){
				request.setAttribute("bierAlInMandje", "Bier is al in mandje. Nieuwe waarde overschrijft oude.");
				request.setAttribute("oudAantal", mandje.get(bierId));
			}
			
		}
		
		
		request.setAttribute("bier", bierService.readBierSoortAndBrouwer(bierId));
		}
		catch(NumberFormatException ex){
			request.setAttribute("fout", "BierNr mag niet leeg zijn. Mag enkel cijfers bevatten.");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameter("aantal").isEmpty()) {
		try {
			int aantal = Integer.parseInt(request.getParameter("aantal"));
			if (aantal > 0){
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				Map<Long, Integer> mandje = (Map<Long, Integer>) session.getAttribute("mandje");
				if(mandje == null) {
					mandje = new HashMap<>();
				}
				mandje.put(Long.parseLong(request.getParameter("bierNr")), aantal);
				session.setAttribute("mandje", mandje);
				response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
			} else {
				request.setAttribute("fout", "Getal moet groter dan 0 zijn.");
				this.doGet(request, response);
			}
		} catch (NumberFormatException ex) {
			request.setAttribute("fout", "Enkel getallen invullen");
			this.doGet(request, response);
		}
		} else {
			request.setAttribute("fout", "Getal mag niet leeg zijn");
			this.doGet(request, response);
		}
		
	}
}
