package General_Programs;

import java.util.Scanner;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int rows = 0;
		int cols = 0;
		System.out.println("Making a 2d array...");
		System.out.print("Enter number of rows : ");
		rows = sc.nextInt();
		System.out.print("Enter number of columns : ");
		cols = sc.nextInt();
		int[][] array = new int[rows][cols];
		
		System.out.println("You are going to make array with "+rows+" rows and "+cols+" columns." );
		
		for(int i = 0; i< rows; i++) {
			for(int j = 0; j<cols; j++) {
				System.out.print("Enter element for index["+i+"]["+j+"] : ");
				array[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Elements of array you entered : ");
		for(int i = 0; i< rows; i++) {
			for(int j = 0; j<cols; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();

	}

}
