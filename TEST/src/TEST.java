
abstract class Animal {  
    abstract void eat();  
}  
class Cat extends Animal{
	public void eat() {
		System.out.print("�Y��");
	}
	public void work() {
		System.out.print("��ѹ�");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.print("�Y���Y");
	}
	public void work() {
		System.out.print("�ݮa");
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