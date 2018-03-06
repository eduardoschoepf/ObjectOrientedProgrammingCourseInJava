class Employee {
	private final static int retirementAge = 65;
	public static int getRetirementAge () {
		return retirementAge;
	}
}

class Company {  
    public static void main(String args[]) {
    		System.out.println( Employee.getRetirementAge() );
    }
}