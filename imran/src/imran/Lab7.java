package imran;

public class Lab7 {
	// before refactoring
//	public void calculate() {
//	    for(int i = 0; i < 1000; i++) {
//	        sum += i;
//	    }
//	}

	// After refactoring
	public int calculateSum(int limit) {
	    int result = 0;
	    for (int i = 0; i < limit; i++) {
	        result += i;
	    }
	    return result;
	}
	public static void main(String[] args) {
        // Create an instance of the Lab7 class
        Lab7 lab7 = new Lab7();

        // Call the refactored method with a limit of 1000
        int sum = lab7.calculateSum(1000);

        // Output the result
        System.out.println("The sum of numbers from 0 to 999 is: " + sum);
    }

}
