package cinema;

class CinemaTheatre {
    private static char[][] cinemaRoom;
    private final int capacity;
    private final int rows;
    private final int seats;

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
                char state = i == 0 ? j == 0 ? ' ' : (char) ('0' + j) : j == 0 ? (char) ('0' + i) : 'S';
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

    int bookSeat(int row, int seat) {
        if (row > rows || seat > seats || cinemaRoom[row][seat] != 'S') {
            return -1;
        }
        cinemaRoom[row][seat] = 'B';
        return calcSeatPrice(row);
    }

    private int calcSeatPrice(int row) {
        return capacity <= 60 || row <= (rows / 2) ? 10 : 8;
    }

    private int calcProfit(int rows, int seats) {
        if (rows * seats <= 60) {
            return rows * seats * 10;
        } else {
            return rows / 2 * seats * 10 + (rows - rows / 2) * seats * 8;
        }
    }
}