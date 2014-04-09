package be.vdab.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

/**
 * Servlet implementation class WinkelWagenServlet
 */
@WebServlet("/winkelwagen.htm")
public class WinkelWagenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/winkelwagen.jsp";
	private static final String REDIRECT_URL = "/WEB-INF/JSP/bevestiging.jsp";
	private transient final BierService bierService = new BierService();
	private transient final BestelbonService bestelbonService = new BestelbonService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> mandje = (Map<Long, Integer>) session
					.getAttribute("mandje");
			if (mandje != null) {
				Set<BestelbonLijn> bestelbonLijnen = new HashSet<>();
				for (Entry<Long, Integer> entry : mandje.entrySet()) {
					bestelbonLijnen.add(new BestelbonLijn(entry.getValue(),
							bierService.read(entry.getKey())));
				}
				request.setAttribute("bestelbon",
						new Bestelbon(bestelbonLijnen));
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// TODO controles
		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> mandje = (Map<Long, Integer>) session
					.getAttribute("mandje");
			if (mandje != null) {
				String naam = request.getParameter("naam");
				String straat = request.getParameter("straat");
				String huisNr = request.getParameter("huisNr");
				int postCode = Integer.parseInt(request.getParameter("postCode"));//TODO numberformatexeption
				String gemeente = request.getParameter("gemeente");
				Adres adres = new Adres(straat, huisNr, postCode, gemeente);
				Set<BestelbonLijn> bestelbonLijnen = new HashSet<>();
				for (Entry<Long, Integer> entry : mandje.entrySet()) {
					bestelbonLijnen.add(new BestelbonLijn(entry.getValue(),
							bierService.read(entry.getKey())));
				}
				Bestelbon bestelbon = new Bestelbon(naam, adres, bestelbonLijnen);
				bestelbonService.create(bestelbon);
				session.invalidate();
				
				request.setAttribute("bestelbon", bestelbon.getBonNr());
				request.getRequestDispatcher(REDIRECT_URL).forward(request, response);
			}
		}
	}

}
