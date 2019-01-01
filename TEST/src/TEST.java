
abstract class Animal {  
    abstract void eat();  
}  
class Cat extends Animal{
	public void eat() {
		System.out.print("吃魚");
	}
	public void work() {
		System.out.print("抓老鼠");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.print("吃骨頭");
	}
	public void work() {
		System.out.print("看家");
	}
}

public class TEST {
    public static void main(String[] args) {
     
  }  
    public static void show(Animal a) {
    	a.eat();
    	
    	if(a instanceof Cat) {
    		Cat c = (Cat)a;
    		c.work();
    	}
    	else if (a instanceof Dog) {
    		
    	}
    }        
    
}