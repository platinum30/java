package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Application {
	public static void main(String[] args) {
		// AnnotationConfigApplicationContext - spring container
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class)) {
			// MyBean b1 = ctx.getBean(MyBean.class);
			Component c1 = ctx.getBean(Component.class);
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
