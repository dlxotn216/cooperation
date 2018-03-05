package taesu.faster.coop.cooperation.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-03-05
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}
	
	/**
	 * Map, ResponseEntity 등 MessageConverter를 사용해야하는 type을 Controller에서 반환하는 API의 경우
	 * postHandle에서 response를 조작할 수 없다.
	 * 
	 * Response를 사전에 만들어 내면서(postHandle 호출 전에) commit해버리기 때문
	 * 
	 * Model, ModelAndView 를 반환하는 경우 DispatcherServlet에서 Response를 생성해내며 commit하기 때문에 response 조작 가능하다
	 *
	 * @param request RequestFacade
	 * @param response ServletResponse
	 * @param handler Handler
	 * @param modelAndView Controller에서 반환해낸 MdoelAndView
	 * @throws Exception exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		response.setHeader("test", "testValue");
	}
	
	/**
	 * 위와 동일한 문제 주의
	 * 
	 * @param request RequestFacade
	 * @param response ServletResponse
	 * @param handler Handler
	 * @param ex exception
	 * @throws Exception exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
		response.setHeader("testInCompletion", "testInCompletion");
	}
}
