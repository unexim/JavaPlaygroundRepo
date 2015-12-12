package internalTrainingsTask;

public class Car extends Vehicle {
	
	public Car(int numberOfWheels, String model, EngineType engineType, double maxSpeed){
		
		setWheels(numberOfWheels);
		setModel(model);
		setEngineType(engineType);
		setMaxSpeed(maxSpeed);
		
		MyLogger.log("A Car was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
		
	}
	
	public Car(){		
		this(4,"unknown", DEFAULT_ENGINE, 0);
		
		MyLogger.log("A Car was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
	}
	
	@Override
	public void Move() {
		
		MyLogger.log("The Car is moving \n");
	}

}
