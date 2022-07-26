package cl.exql.saop.proxy;

public class LoggerAspect {

    public void logBefore() {
        System.out.println("Logging before method being executed... ");
    }

    public void logAfter() {
        System.out.println("Logging after method being executed... ");
    }
}
