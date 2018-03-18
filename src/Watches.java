import java.util.ArrayList;

interface DigitalMechanism {
	//..
}
interface AnalogueMechanism {
	//..
}

abstract class Product {
	private final double value;
	
	public Product(double val) {
		value = val;
	}
	
	public Product() {
		value = 0.0;
	}
	
	public double price() {
		return value;
	}
	
	public String toString() {
		return Double.toString(price());
	}
}

class Watch extends Product {
	private Mechanism core;
	private ArrayList<Accessory> accessories;
	
	public Watch() {
		accessories = new ArrayList<Accessory>();
	}
	
	public void add(Accessory accessory) {
		accessories.add(accessory);
	}
	
	@Override
	public double price() {
		double priceFinal = super.price();
		for (Accessory acc : accessories) {
			priceFinal += acc.price();
		}
		return priceFinal;
	}
	
	public void display() {
		System.out.print("Une montre ");
		System.out.println("composée de :");
		for (Accessory acc : accessories) {
			System.out.println(" * " + acc);
		}
		System.out.print("==> Prix total : ");
		System.out.println(price());
	}
}

class Mechanism extends Product {
	//..
}

class Accessory extends Product {
	private final String name;
	
	public Accessory(String nameAccessory, double value) {
		super(value);
		name = nameAccessory;
	}
	
	@Override
	public String toString() {
		String result = name + " coutant " ;
		result += super.toString();
		return result;
		
	}
}

class DoubleMechanism extends Mechanism implements AnalogueMechanism, DigitalMechanism {
	//..
}

class Bracelet extends Accessory {
	public Bracelet(String name, double value) {
		super("bracelet " + name, value);
	}
}

class Clasp extends Accessory {
	public Clasp(String name, double value) {
		super("clasp " + name, value);
	}
}

public class Watches {
	public static void main(String arg[]) {
		Watch w = new Watch();
		
		w.add(new Bracelet("cuir" , 54.0));
		w.add(new Clasp("acier" , 12.5));
		
		System.out.println('\n' + "Montre w :");
		w.display();
	}
}