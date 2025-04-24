package Basic_Problems;

public class Problem02 {
	
	public static int sumToN(int n) {
		if(n == 0) {
			return 0;
		}
		
		return n += sumToN(n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sumToN(10));

	}

}
