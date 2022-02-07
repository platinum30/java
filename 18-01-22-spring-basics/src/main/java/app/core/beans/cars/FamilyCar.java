package app.core.beans.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("family-car")
@Scope("prototype")
public class FamilyCar implements Car {
	 int number;
	 
	 @Autowired
	 Engine engine;
	 @Autowired
	 @Qualifier("automaticGear")
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
		return "Family-Car";
	}

	@Override
	public String getGearModel() {
		// TODO Auto-generated method stub
		return this.gear.getModel();
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "FamilyCar [number=" + number + ", engine=" + engine.getModel() + ", gear=" + gear.getModel() + "]";
	}

}
