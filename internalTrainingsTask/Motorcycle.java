package internalTrainingsTask;

public class Motorcycle extends Vehicle{
	
	// Constructors
	
	public Motorcycle(int numberOfWheels, String model, EngineType engineType, double maxSpeed) {
		
		setWheels(numberOfWheels);
		setModel(model);
		setEngineType(engineType);
		setMaxSpeed(maxSpeed);
		
		MyLogger.log("A Motorcycle was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
		
	}
	
	public Motorcycle() {
		this(2,"unknown", DEFAULT_ENGINE,0);
		 
		MyLogger.log("A Motorcycle was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
	}
	
	
	// Methods
	
	@Override
	public void Move() {
		
		MyLogger.log("The Motorcycle is moving \n");
		
	}

}
