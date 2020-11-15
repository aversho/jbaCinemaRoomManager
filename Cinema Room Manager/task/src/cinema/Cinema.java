package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        System.out.println("Total income:");
        System.out.println("$" + calcProfit(rows, seats));
    }

    private static int calcProfit(int rows, int seats) {
        if (rows * seats <= 60) {
            return rows * seats * 10;
        } else {
            return rows / 2 * seats * 10 + (rows - rows / 2) * seats * 8;
        }
    }
}