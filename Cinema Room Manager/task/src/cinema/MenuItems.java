package cinema;

public enum MenuItems {
    SHOW(1, "Show the seats"), BUY(2, "Buy a ticket"), EXIT(0, "Exit");
    private final String menuText;
    private final int menuNumber;

    MenuItems(int number, String text) {
        menuText = text;
        menuNumber = number;
    }

    public static void printVariants(){
        for (MenuItems elem : values()) {
            System.out.printf("%d. %s%n", elem.menuNumber, elem.menuText);
        }
    }

    public static MenuItems findByNumber(int number) {
        for (MenuItems elem : values()) {
            if (elem.menuNumber == number) {
                return elem;
            }
        }
        return null;
    }
}
