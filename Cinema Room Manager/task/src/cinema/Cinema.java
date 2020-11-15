package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private static char[][] cinemaRoom;
    private static int capacity;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        System.out.println();

        initState(rows, seats);
        printCinemaRoom();

        System.out.println("Enter a row number:");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = sc.nextInt();
        System.out.println();

        System.out.println("Ticket price: $" + bookSeat(row, seat));
        System.out.println();
        printCinemaRoom();
    }

    private static void initState(int rows, int seats) {
        cinemaRoom = new char[rows + 1][seats + 1];
        capacity = rows * seats;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                char state = i == 0 ? j == 0 ? ' ' : (char) ('0' + j) : j == 0 ? (char) ('0' + i) : 'S';
                cinemaRoom[i][j] = state;
            }
        }
    }

    private static void printCinemaRoom() {
        System.out.println("Cinema:");
        for (char[] row : cinemaRoom) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int bookSeat(int row, int seat) {
        if (row > cinemaRoom.length || seat > cinemaRoom[row].length || cinemaRoom[row][seat] != 'S') {
            return 0;
        }
        cinemaRoom[row][seat] = 'B';
        return getPrice(row);
    }

    private static int getPrice(int row) {
        if (capacity <= 60) {
            return 10;
        }

        return row <= (cinemaRoom.length - 1) / 2 ? 10 : 8;
    }

    private static int calcProfit(int rows, int seats) {
        if (rows * seats <= 60) {
            return rows * seats * 10;
        } else {
            return rows / 2 * seats * 10 + (rows - rows / 2) * seats * 8;
        }
    }
}