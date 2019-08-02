package org.bookticket;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.common.util.concurrent.RateLimiter;

/**
 * This class can filter the request going to API and enforce the limit as
 * below.
 */
@WebFilter(filterName = "RateLimiterFilter", urlPatterns = { "/*" })
public class RateLimiterFilter implements Filter {

	private static final int TIME_LIMIT = 3600000; // time in millisecond
	private RateLimiter rateLimiter = null; // using ratelimiter library from the google guava project.

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		rateLimiter = RateLimiter.create(0.027777777777778); // 100 requests per hour (100/3600)
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) servletResponse;
		if (rateLimiter.tryAcquire()) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			res.addIntHeader("Rate limit exceeded. Try again in", TIME_LIMIT);
			res.sendError(429);
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {

	}

}