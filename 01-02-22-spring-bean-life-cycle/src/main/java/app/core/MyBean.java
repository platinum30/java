package app.core;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware, InitializingBean, DisposableBean {

	{
		System.out.println(">>>>>>>>>>>> instantiate");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean started");

	}

	@Override
	public void setBeanName(String name) {
		System.out.println("name set");

	}
}
