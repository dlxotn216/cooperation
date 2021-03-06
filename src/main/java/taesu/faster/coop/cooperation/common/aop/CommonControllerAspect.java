package taesu.faster.coop.cooperation.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 
 * Controller에 AOP를 설정 하여 API의 수행 시간을 측정한다
 * 
 * 또는 ResponseBodyAdvice<Object> 인터페이스를 구현 한 @ControllerAdvice 어노테이션을 가진 Bean으로 처리할 수 있다
 * (Interceptor의 preHandle에서 startTime을 기록해주어야 한다) 
 * 
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-03-05
 */
@Aspect
@Component
@Slf4j
public class CommonControllerAspect {
	@Around("execution(public * taesu.faster.coop.cooperation.*.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();
		Object result = joinPoint.proceed();
		long endTime = System.nanoTime();
		
		if(result instanceof Map) {
			Map<String, Object> responseMap = (Map<String, Object>) result;
			responseMap.put("elapseTime", (endTime - startTime) / 1000000);
		}
		log.info(":::::AOP Before REST call:::::" + result);
		return result;
	}
}
