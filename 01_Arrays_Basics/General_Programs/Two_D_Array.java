package General_Programs;

import java.util.Scanner;

public class Two_D_Array {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int rows = 0;
        int cols = 0;
        char choice = 'y';
        System.out.println("Making a 2d array...");
        System.out.print("Enter number of rows : ");
        rows = sc.nextInt();
        do {
            System.out.print("Enter number of columns : ");
            cols = sc.nextInt();
            System.out.println("Please enter columns == 2.");
        } while (cols != 2);
        sc.nextLine();
        
        String[][] array = new String[rows][cols];

        System.out.println("You are going to make array with " + rows + " rows and " + cols + " columns.");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    System.out.println("Enter name : ");
                    array[i][j] = sc.nextLine();
                }
                if (j == 1) {
                    System.out.println("Enter number : ");
                    array[i][j] = sc.nextLine();
                }

            }
        }

        System.out.println("Data you entered is : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();

    }

}
