package taesu.faster.coop.cooperation.common.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-03-05
 */
@ControllerAdvice
public class CommonErrorHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public @ResponseBody
	Map<String, Object> handleError404(HttpServletRequest request, Exception e)   {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("error", "404");
		
		return errorResponse;
	}
	
	@ExceptionHandler(value = {Exception.class})
	public @ResponseBody
	Map<String, Object> handleException(Exception exception) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("error", "error");
		
		return errorResponse;
	}
}
