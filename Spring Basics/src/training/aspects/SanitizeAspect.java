package training.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import training.entity.Product;

@Component
@Aspect
public class SanitizeAspect {

	@Around("execution(* training.dao.ProductDao.get*(Double, Double))")
	public Object swap(ProceedingJoinPoint pjp) throws Throwable {
		Double d1 = (Double) pjp.getArgs()[0];
		Double d2 = (Double) pjp.getArgs()[1];
		Object[] args = { d1, d2 };
		if (d1 > d2) {
			args = new Object[] { d2, d1 };
		}
		return pjp.proceed(args);
	}

	@Around("execution(* *(training.entity.Product))")
	public Object doSanitize(ProceedingJoinPoint pjp) throws Throwable {
		// change the product name to uppercase
		// change the price to abs(price)
		Product p = (Product) pjp.getArgs()[0];
		p.setProductName(p.getProductName().toUpperCase());
		p.setUnitPrice(Math.abs(p.getUnitPrice()));

		return pjp.proceed(new Object[] { p });

	}
}
