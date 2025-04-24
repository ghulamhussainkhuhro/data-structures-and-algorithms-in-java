package Basic_Problems;

public class Problem04 {

	public static long fib(int n) {
		if (n < 1)
			return 0;
		if (n < 3)
			return 1;
		else 
			return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 90; i++) { // modified loop to start from 1 and end at 90
			long t0 = System.currentTimeMillis();
			long m = fib(i);
			long t1 = System.currentTimeMillis();
			System.out.println("fab(" + i + ") = " + m + " Time: " + (t1 - t0));
		}
		for (int i = 90; i <= 100; i++) {
			long t0 = System.currentTimeMillis();
			long m = fib(i);
			long t1 = System.currentTimeMillis();
			// System.out.println("fab("+i+")"+m+"Time: "+ (t1-t0));
			System.out.println("fab(" + i + ") = " + m + " Time: " + (t1 - t0));
		}
		
		System.out.println(fib(10));

	}

}