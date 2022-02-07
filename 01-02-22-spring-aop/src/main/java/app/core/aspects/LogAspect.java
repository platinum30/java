package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before(" (void buy*(int))") // (..) will catch buy method that get any args
	public void beforeBuyAdvice(JoinPoint j) {
		System.out.println(">>>>> before buy " + j.getSignature().getName());
	}

	@After("execution(void buy*(int))") // (..) will catch buy method that get any args
	public void afterBuyAdvice(JoinPoint j) {
		System.out.println(">>>>> after buy " + j.getSignature().getName() + "\n\n");
	}
}
