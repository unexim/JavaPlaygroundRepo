package internalTrainingsTask;

public class Truck extends Vehicle {
	
	public Truck(int numberOfWheels,String model, EngineType engineType, double maxSpeed){
		
		setWheels(numberOfWheels); 
		setModel(model);
		setEngineType(engineType);
		setMaxSpeed(maxSpeed);
		
		MyLogger.log("A Truck was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
		
	}
	
	public Truck(){
		this(4,"unknown",DEFAULT_ENGINE,0);
		
		MyLogger.log("A Truck was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
	}

	@Override
	public void Move() {
		
		MyLogger.log("The Truck is moving! \n");
	}
			
}
