package cinema;

import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CinemaTheatre cinemaTheatre = new CinemaTheatre(askForTotalRows(), askForTotalSeats());

        while (true) {
            switch (askForMenu()) {
                case BUY:
                    System.out.printf("Ticket price: $%d\n\n", cinemaTheatre.bookSeat(askForRow(),askForSeat()));
                    break;
                case SHOW:
                    cinemaTheatre.printRoom();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    static int askForTotalRows(){
        System.out.println("\nEnter the number of rows:");
        return scanner.nextInt();
    }

    static int askForTotalSeats(){
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }

    static MenuItems askForMenu() {
        MenuItems.printVariants();
        return MenuItems.findByNumber(scanner.nextInt());
    }

    static int askForRow(){
        System.out.println("\nEnter a row number:");
        return scanner.nextInt();
    }

    static int askForSeat(){
        System.out.println("Enter a seat number in that row:");
        return scanner.nextInt();
    }
}