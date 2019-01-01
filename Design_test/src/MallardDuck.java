
public class MallardDuck extends Duck{
	public MallardDuck() {
		quackBejavior = new Quack();
		flyBehavior= new FlyWithWings();
	}
	
	public void display() {
		System.out.println("Im a real Mallard duck");
	}
}
