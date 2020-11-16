package cinema;

class CinemaTheatre {
    private final char SEAT_BOOKED = 'B';
    private final char SEAT_FOR_SELL = 'S';
    private final int PRICE_FULL = 10;
    private final int PRICE_DISCOUNT = 8;
    private char[][] cinemaRoom;
    private final int capacity;
    private final int rows;
    private final int seats;
    private int soldTickets = 0;
    private int profit = 0;


    CinemaTheatre(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.capacity = rows * seats;

        initRoom();
    }

    private void initRoom() {
        cinemaRoom = new char[rows + 1][seats + 1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                char state = i == 0 ? j == 0 ? ' ' : (char) ('0' + j) : j == 0 ? (char) ('0' + i) : SEAT_FOR_SELL;
                cinemaRoom[i][j] = state;
            }
        }
    }

    void printRoom() {
        System.out.println("\nCinema:");
        for (char[] row : cinemaRoom) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printStat() {
        System.out.printf("\nNumber of purchased tickets: %d\n" +
                        "Percentage: %.2f%%\n" +
                        "Current income: $%d\n" +
                        "Total income: $%d\n",
                soldTickets,
                100.0 * soldTickets / capacity,
                profit,
                calcProfit());
    }

    void buyTicket() {
        int price;

        do {
            price = bookSeat(Cinema.askForRow(), Cinema.askForSeat());
        } while (price < 0);

        soldTickets++;
        profit += price;
        System.out.printf("Ticket price: $%d\n\n", price);
    }

    int bookSeat(int row, int seat) {
        if (row > rows || seat > seats || row < 1 || seat < 1) {
            System.out.println("\nWrong input!");
            return -1;
        }
        if (cinemaRoom[row][seat] == SEAT_BOOKED) {
            System.out.println("\nThat ticket has already been purchased!");
            return -1;
        }
        cinemaRoom[row][seat] = SEAT_BOOKED;

        return calcSeatPrice(row);
    }

    private int calcSeatPrice(int row) {
        return capacity <= 60 || row <= (rows / 2) ? PRICE_FULL : PRICE_DISCOUNT;
    }

    private int calcProfit() {
        if (capacity <= 60) {
            return capacity * PRICE_FULL;
        } else {
            return (rows / 2) * seats * PRICE_FULL + (rows - rows / 2) * seats * PRICE_DISCOUNT;
        }
    }
}