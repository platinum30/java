package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.brokers.Broker;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class App1 {
	public static void main(String[] args) {
		// AnnotationConfigApplicationContext - spring container
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App1.class)) {
			Broker b = ctx.getBean(Broker.class);
			b.buyStocks(25);
			b.buyCars(3);
			b.buyStocks(5);
			b.sell(7);
			b.sell(2);
			b.buyCars(3);
			b.sell(20);
		}
	}
}
