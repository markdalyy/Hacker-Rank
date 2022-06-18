package day3;

import java.util.Scanner;

public class TowerBreakers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of towers: ");
        int n = scanner.nextInt(); // num towers
        System.out.print("Enter height of each tower: ");
        int m = scanner.nextInt(); // height of each tower
        System.out.printf( "Winner: P%d", (n % 2 == 0 || m == 1) ? 2 : 1 );
    }
}
