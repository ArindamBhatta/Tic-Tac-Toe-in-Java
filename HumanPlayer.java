import java.util.Scanner;

public class HumanPlayer extends PlayerInterface {

    private static final Scanner scan = new Scanner(System.in);

    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    public void makeMove() {
        int row = -1;
        int col = -1;
        do {
            System.out.println("Enter row and column");
            if (scan.hasNextInt()) {
                row = scan.nextInt();
                col = scan.nextInt();
            } else {
                System.out.println("Invalid input. Please enter two integers separated by space.");
                continue;
            }
        } while (!isValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);
    }

}
