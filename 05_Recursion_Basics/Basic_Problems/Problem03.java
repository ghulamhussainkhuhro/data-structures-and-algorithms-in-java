package Basic_Problems;

public class Problem03 {
	
	public static int calcFact(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return n *= calcFact(n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Factorial of 5 is "+calcFact(5));

	}

}
