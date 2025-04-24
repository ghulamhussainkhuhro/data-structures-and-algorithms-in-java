package Basic_Problems;

public class Problem01 {
	public static void printBackwards(int n) {
		if(n == 0) {
			return;
		}
		System.out.print(n+" ");
		printBackwards(n-1);
		
		
		
	}
	
	public static void printForward(int n) {
	    if (n <= 0) {
	        return;
	    }
	    printForward(n - 1);
	    System.out.print(n + " ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printBackwards(5);
		System.out.println();
		printForward(5);

	}

}
