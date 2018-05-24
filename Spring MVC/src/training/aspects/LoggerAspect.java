package training.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	@Before("execution(* training.dao.ProductDao.get*(..))")
	public void logFirst(JoinPoint jp){
		System.err.println(">>>>>>>>> Calling: " + jp.getSignature().getDeclaringTypeName()+"."
				+jp.getSignature().getName());
		System.err.println(">>>>>>>>> Arguments: " + Arrays.toString(jp.getArgs()));
	}
}
