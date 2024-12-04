package animalCounter;

public class Alligator extends Animal implements Countable{
	private Sheep sheep;
	
	public Alligator(Sheep sheep) {
		this.sheep = sheep; 
		this.count = 0;
		
	}

	public void incrementCount() {
		// adds 1 alligator and subtracts 1 sheep
		if (sheep.count > 0) {
			sheep.count -= 1;
			this.count += 1; 
			System.out.println("One alligator added. One sheep removed.");
		} else {
			System.out.println("Add more sheep before adding another alligator");
		}
		
		
	}

}
