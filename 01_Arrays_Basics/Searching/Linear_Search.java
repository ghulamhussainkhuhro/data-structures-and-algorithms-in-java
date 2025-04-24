package Searching;

public class Linear_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		
		int num = 5;
		
		for(int i=0; i <= arr.length -1; i++) {
			if(arr[i] == num) {
				System.out.println("Number "+num+" found at index "+i);
			}
			
		}
		

	}

}
