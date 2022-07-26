package cl.exql.saop.terms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cl.exql.saop.terms")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
