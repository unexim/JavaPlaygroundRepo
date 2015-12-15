package internalTrainingsTask;

public class Exection {

	public static void main(String[] args) {
		
		Vehicle vehicle1 = new Boat();
		vehicle1.Move();
		((Boat) vehicle1).Floating();
			
		Truck truck = new Truck();
		truck.Move();
		
		Car car = new Car(4,"Audi",EngineType.DieselEngine,200);
		car.Move();
		
		Car audi = new Audi(4,"A4",EngineType.PetrolEngine,200,"2002");
		audi.Move();
	}

}
