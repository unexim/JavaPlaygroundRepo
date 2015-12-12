package internalTrainingsTask;

public class Exection {

	public static void main(String[] args) {
		
		Truck truck = new Truck(8, "Kamaz", EngineType.DieselEngine, 80);
		truck.Move();
		Truck defaultTruck = new Truck();
		defaultTruck.Move();
		
		Motorcycle moto = new Motorcycle();
		moto.Move();
		
		Audi audi = new Audi(4, "A4", EngineType.PetrolEngine, 200, "2000");
		audi.Move();
		audi.getYear();
		
		
	}

}
