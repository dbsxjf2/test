package advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionAdvice {
	private void invoke(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Start Transaction!");
		pjp.proceed();
		System.out.println("End Transaction!");
	}
}
