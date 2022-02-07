package app.core.beans.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("racing-car")
@Scope("prototype")
public class RacingCar implements Car {
	 int number;
	 
	 @Autowired
	 @Qualifier("turboEngine")
	 Engine engine;
	 @Autowired
	 @Qualifier("manualGear")
	 Gear gear;
	@Override
	
	public int getNumber() {
		// TODO Auto-generated method stub
		return this.number;
	}

	@Override
	public String getEngineModel() {
		// TODO Auto-generated method stub
		return this.engine.getModel();
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return "Racing-Car";
	}

	@Override
	public String getGearModel() {
		// TODO Auto-generated method stub
		return this.gear.getModel();
	}

	@Override
	public String toString() {
		return "RacingCar [number=" + number + ", engine=" + engine.getModel() + ", gear=" + gear.getModel() + "]";
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
