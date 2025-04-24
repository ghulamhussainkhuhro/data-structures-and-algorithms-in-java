package Searching;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3,3,3,4, 4, 5, 6, 7,8};
		long t1 = System.currentTimeMillis();
		System.out.println("Time Before : "+t1);
		int mid1 = binarySearch(arr, 3);
		System.out.println(mid1);
		System.out.println(duplicates(arr,mid1,3));
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time After : "+t2);
		
	}
	public static int binarySearch(int[] arr, int x) {
		  int low = 0;
		  int high = arr.length - 1;
		  int mid;

		  while (low < high) {
		    mid = low + (high - low) / 2;

		    if (arr[mid] == x) {
		      return mid;
		    } else if (arr[mid] < x) {
		      low = mid + 1;
		    } else {
		      high = mid - 1;
		    }
		  }

		  return -1; // element not found
		}
	public static void sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
//					swap:
					int temp = arr[j];
						arr[j] =arr[j+1];
						arr[j+1]=temp;
				}
			}
		}
	}
	
	public static int duplicates(int[] arr, int mid, int key) {
		int count = 1;
		int i = mid;
		while(arr[i+1] == key) {
			count++;
			i++;
		}
		i = mid;
		while(arr[i-1] == key) {
			count++;
			i--;
		}
		
		return count;
	}
	 


}
