package internalTrainingsTask;


public abstract class Vehicle {
	
	// Constants
	protected static final EngineType DEFAULT_ENGINE = EngineType.PetrolEngine;
	
	// Fields
	private int wheels;
	private String model;
	private EngineType engineType;
	private double maxSpeed;
	
	// Methods (getters & setters)
	public int getWheels(){
		
		return this.wheels;
	}
	
	public void setWheels(int value){
		
		this.wheels = value;
	}
	
	public String getModel(){
		
		return this.model;
	}
	
	public void setModel(String value){
				
		this.model = value;
	}
	
	public EngineType getEngineType(){
		
		return this.engineType;
	}
	
	public void setEngineType(EngineType value){
		
		this.engineType = value;
	}
	
	public double getMaxSpeed(){
		
		return this.maxSpeed;
	}
	
	public void setMaxSpeed(double value){
		
		this.maxSpeed = value;
	}
	
	// Methods
	
	public abstract void Move();
	
}
