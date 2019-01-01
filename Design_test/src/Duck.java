
public  abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBejavior;
	
	
	public abstract void display();
	
	public void performFly() {
		flyBehavior.fly();
	}
	public void performQuack() {
		quackBejavior.quack();
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys");
	}
	
	
}


