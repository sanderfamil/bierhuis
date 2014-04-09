package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
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
				request.setAttribute("mandje",
						new Bestelbon(bestelbonLijnen));
				
			}
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> mandje = (Map<Long, Integer>) session
					.getAttribute("mandje");
			if (mandje != null) {
				
				Map<String, String> fouten = new HashMap<>();
				String naam = validateString(request.getParameter("naam"));
				if(naam.equals("Verplicht.")||naam.equals("Te lang.")){
					fouten.put("naam", naam);
					
				}
				String straat = validateString(request.getParameter("straat"));
				if(straat.equals("Verplicht.")||straat.equals("Te lang.")){
					fouten.put("straat", straat);
				}
								
				
				String huisNr = validateString(request.getParameter("huisNr"));
				if(huisNr.equals("Verplicht.")||huisNr.equals("Te lang.")){
					fouten.put("huisNr", huisNr);
				}
				
				int postCode = 0;
				if(request.getParameter("postCode")!=null){
				try{
					postCode = Integer.parseInt(request.getParameter("postCode"));
				}catch(NumberFormatException ex){
					fouten.put("postCode", "Tik een positief getal tussen 1000 en 9999");
				}
				}
				
				String gemeente = validateString(request.getParameter("gemeente"));
				if(gemeente.equals("Verplicht.")||gemeente.equals("Te lang.")){
					fouten.put("gemeente", gemeente);
				}
				if(fouten.isEmpty()){
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
				request.getRequestDispatcher(REDIRECT_URL).forward(request, response);}
				else{
					request.setAttribute("fouten", fouten);
					this.doGet(request, response);
				}

			}
		}
	}

	public String validateString(String string){
		if(string.isEmpty()){
			return "Verplicht.";
		}
		else{
			if(string.length()>50){
				return "Te lang.";
			}
			else{
				return string;
			}
		}
	}
}
