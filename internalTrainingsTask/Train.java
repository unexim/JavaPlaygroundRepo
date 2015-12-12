package internalTrainingsTask;

public class Train extends Vehicle implements RailWayVehicle{
	
	// Fields
	private boolean hasPassangers;
	
	public Train(int numberOfWheels, String model, EngineType engineType, double maxSpeed, boolean hasPassangers){
		
		setWheels(numberOfWheels);
		setModel(model);
		setEngineType(engineType);
		setMaxSpeed(maxSpeed);
		setHasPassangers(hasPassangers);
		
		MyLogger.log("A Train was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
		
	}
	
	public Train(){		
		this(4,"unknown", DEFAULT_ENGINE, 0, false);
		
		MyLogger.log("A Train was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n");
	}
	
	public void setHasPassangers(boolean value){
		
		this.hasPassangers = value;
	}
	
	@Override
	public void Move() {
		MyLogger.log("The Train has moved \n");
		
	}

	@Override
	public boolean hasPassangers() {
		
		if(this.hasPassangers == true){
			
			return true;
		}
		
		return false;
	}
}
