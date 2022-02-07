package app.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.cars.FamilyCar;
import app.core.beans.cars.RacingCar;

public class CarsApp {
	public static void main(String[] args) {
		System.out.println("start");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigCar.class)) {
			FamilyCar familyCar = ctx.getBean("family-car", FamilyCar.class);
			familyCar.setNumber(101);
			System.out.println(familyCar);
			
			RacingCar racingCar = ctx.getBean("racing-car", RacingCar.class);
			racingCar.setNumber(102);
			System.out.println(racingCar);
	
			RacingCar racingCar2 = ctx.getBean("racing-car", RacingCar.class);
			racingCar2.setNumber(103);
			System.out.println(racingCar2);
		}
		System.out.println("stop");
	}
}
