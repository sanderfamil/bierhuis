package be.vdab.filters;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.htm")
public class JPAFilter implements Filter {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("bierhuis");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		context.setAttribute("contextPath", context.getContextPath());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}

}
