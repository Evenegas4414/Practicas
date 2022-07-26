package cl.exql.saop.terms;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* * (..))")
    public void logBefore() {
        System.out.println("Logging before method being executed...");
    }

    public void logAfter() {
        System.out.println("Logging after method being executed...");
    }
}
