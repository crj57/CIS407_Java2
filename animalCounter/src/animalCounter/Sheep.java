package animalCounter;

public class Sheep extends Animal implements Countable {
	
	public Sheep() {
		this.count = 0;
	}

	
	public void incrementCount() {
		//adds 2 more sheep
		this.count += 2;
		
		
	}

}
