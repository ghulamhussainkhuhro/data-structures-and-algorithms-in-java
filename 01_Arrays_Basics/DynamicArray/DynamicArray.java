package DynamicArray;

import java.util.Scanner;

public class DynamicArray {
    Integer []arr;
    int size=0;
    Scanner sc=new Scanner(System.in);
    DynamicArray(int capacity){
        arr=new Integer[capacity];
    }
    public void insert(){
        if(size==arr.length)
           resize();
        System.out.println("Enter the Number : ");
        arr[size++]=sc.nextInt();
    }
    private void resize(){
        Integer [] temp=arr;
        arr=new Integer[2*temp.length];
        System.arraycopy(temp, 0, arr, 0, size);
    }
    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void bubbleSort(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
               if(arr[j]>arr[j+1]){
                  int temp =arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
                }
            }
        }
    }
    public void delete(){
        System.out.println("Enter Number you want to delete : ");
        int key=sc.nextInt();
        for(int i=0;i<size;i++){
            if(arr[i]==key){
                for(int j=i;j<size-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[size-1]=null;
            }
        }
    }
    public void update(){
        System.out.println("Enter Number you want to update : ");
        int key=sc.nextInt();
        for(int i=0;i<size;i++){
            if(arr[i]==key){
                System.out.println("Enter New Value");
                arr[i]=sc.nextInt();
                break;
            }
        }
    }
    public void linearSearch(){
        System.out.println("Enter Number you want to search : ");
        int key=sc.nextInt();
        boolean isFound=false;
        for(int i=0;i<size;i++){
            if(arr[i]==key) {
              isFound=true;
              break;
            }
        }
        if(isFound){System.out.println("Number Found");}
        else{System.out.println("Not Found");}
    }
    public void binarySearch(){
        System.out.println("Enter Number you want to search : ");
        int key=sc.nextInt();
        bubbleSort();
        boolean isFound=false;
        int mid;
        int first=0;
        int last=size-1;
        while(first<last){
            mid=first+(last-first)/2;
            if(arr[mid]==key)
            {
                isFound=true;
                break;
            }
            if(arr[mid]<key)
            first=mid+1;
            if(arr[mid]>key)
            last=mid-1;
        }
        if(isFound){System.out.println("Number Found");}
        else{System.out.println("Not Found");}
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DynamicArray arr;
        System.out.print("Enter Capacity of array : ");
        int capacity=sc.nextInt();
        arr=new DynamicArray(capacity);
        while(true){
            System.out.println("Select Option : 1:Display , 2:Insert , 3:sort , 4: LinearSearch ,5: BinarySearch ,6: Update,7: Delete ,8:Exit ");
            
            int opt=sc.nextInt();
            switch (opt){
                case 1:arr.display();break;
                case 2:arr.insert();break;
                case 3:arr.bubbleSort();break;
                case 4:arr.linearSearch();break;
                case 5:arr.binarySearch();break;
                case 6:arr.update();break;
                case 7:arr.delete();break;
                case 8: System.exit(0);break;
                default:
                    System.out.println("Try again");
            }
        }       
    } 
}