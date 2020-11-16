package cinema;

import java.util.Scanner;

public class Cinema {
    private static char[][] cinemaRoom;
    private static int capacity;
    private static int rows;
    private static int seats;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();
        System.out.println();

        initCinemaRoom();
        printCinemaRoom();

        System.out.println("Enter a row number:");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = sc.nextInt();
        System.out.println();

        System.out.println("Ticket price: $" + getTicket(row, seat));
        System.out.println();
        printCinemaRoom();
    }

    private static void initCinemaRoom() {
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

    private static int getTicket(int row, int seat) {
        if (row > rows || seat > seats || cinemaRoom[row][seat] != 'S') {
            return -1;
        }
        cinemaRoom[row][seat] = 'B';
        return calcSeatPrice(row);
    }

    private static int calcSeatPrice(int row) {
        return capacity <= 60 || row <= (rows / 2) ? 10 : 8;
    }

    private static int calcProfit(int rows, int seats) {
        if (rows * seats <= 60) {
            return rows * seats * 10;
        } else {
            return rows / 2 * seats * 10 + (rows - rows / 2) * seats * 8;
        }
    }
}