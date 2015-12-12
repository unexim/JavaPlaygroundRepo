package internalTrainingsTask;

public class Boat extends Vehicle implements WaterVehicle {
	
	// Fields
	private boolean hasPassengers;
		
	// Constructors
	
	public Boat(int numberOfWheels, String model, EngineType engineType, double maxSpeed, boolean hasPassengers){
		
		setWheels(numberOfWheels);
		setModel(model);
		setEngineType(engineType);
		setMaxSpeed(maxSpeed);
		setHasPassengers(hasPassengers);
		
		MyLogger.log("A Boat was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n" + " with passengers :" + HasPassengers() + "\n");
		
	}
	
	public Boat(){
		this(0,"unknown",DEFAULT_ENGINE ,0 ,false);
		
		MyLogger.log("A Boat was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n" + " with passengers :" + HasPassengers() + "\n");
		
	}
	
	// Methods (getters & setters)
	
	public void setHasPassengers(boolean value){
		
		if(value != (boolean)value){
			throw new IllegalArgumentException(" value of the parameter is not boolean "); 
		}
		
		this.hasPassengers = value;
	}
	
	@Override
	public boolean HasPassengers(){
		
		return this.hasPassengers;
	}
	
	@Override
	public void Move(){
		
		MyLogger.log("Boat is moving \n");
	}

	@Override
	public void Floating() {
		
		MyLogger.log("boat is floating \n");		
	}
	
	

}
