package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@org.springframework.stereotype.Component
public class Component extends Thread implements InitializingBean, DisposableBean {

	public void print() throws InterruptedException {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("message");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
		}

	}

	@Override
	public void destroy() throws Exception {
		interrupt();
	}
}
