/**
 *
 */
package gl.utsav.vendor.interceptor;

import de.hybris.platform.core.model.user.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception
	{
		final String uri = request.getRequestURI();
		final HttpSession session = request.getSession();
		final UserModel user = (UserModel) session.getAttribute("user");

		if (user == null && !uri.contains("login") && !uri.contains("register") && !uri.contains("logout"))
		{
			/*
			 * JaloSession.getCurrentSession().close(); request.getSession().invalidate();
			 */
			response.sendRedirect("login");
			return false;
		}
		else if (user != null && (uri.contains("login") || uri.contains("register")))
		{
			response.sendRedirect("home");
			return false;
		}
		else
		{
			System.out.println(session.getAttribute("user"));
		}

		return true;
	}
}