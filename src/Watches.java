import java.util.ArrayList;

public interface DigitalMechanism {
	//..
}
public interface AnalogueMechanism {
	//..
}

class Product {
	private double value;
	
	public double price() {
		return value;
	}
	
	public String toString() {
		//..
	}
}

class Watch extends Product {
	private Mechanism core;
	private ArrayList<Accessory> accessories;
}

class Mechanism extends Product {
	//..
}

class Accessory {
	//..
}

class DoubleMechanism extends Mechanism implements AnalogueMechanism, DigitalMechanism {
	//..
}

class Watches {
	public static void main(String arg[]) {
		//..
	}
}