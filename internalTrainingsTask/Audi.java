package internalTrainingsTask;


public final class Audi extends Car {
	
	//Fields 
	
	private String year;
	
	//Constructors
	
	public Audi(int numberOfWheels, String model, EngineType engineType, double maxSpeed, String year){
		super(numberOfWheels, model, engineType, maxSpeed);
		
		setYear(year);
		
		MyLogger.log("An Audi was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n" + getYear() + " year made \n");
	}
	
	public Audi(){
		this(4, "unknown", DEFAULT_ENGINE, 0, "0000");
		MyLogger.log("An Audi was created with : \n" + getWheels() + " Wheels\n" + getModel() + " Model \n" + getEngineType() + " Engine\n" + getMaxSpeed() + " Maxspeed \n" + getYear() + " year made \n");
	} 
	
	//Methods getters & setters 
	
	public void setYear(String value){
		
		this.year = value;
	}
	
	public String getYear(){
		
		return this.year;
	}
	
	//Methods
	
	@Override
	public void Move() {
		
		//System.out.println();
		MyLogger.log("The Audi has moved\n");
		
	}
	
	public void PrintYearOfTheAudi(){
		
		//System.out.println();
		MyLogger.log("The Audi was made in : " + getYear() + "\n");
	}

}
