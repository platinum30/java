package app.core;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@org.springframework.stereotype.Component
public class Component2 extends Thread {

	public void print() throws InterruptedException {

	}

	@PostConstruct // javax annotations dependency
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

	@PreDestroy // javax annotations dependency
	public void destroy() throws Exception {
		interrupt();
	}
}
