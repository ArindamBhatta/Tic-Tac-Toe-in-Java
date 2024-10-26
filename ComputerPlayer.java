import java.util.Random;

public class ComputerPlayer extends PlayerInterface {
    private static final Random value = new Random();

    public ComputerPlayer(String name, char mark) {
        super(name, mark);
    }

    public void makeMove() {
        int row;
        int col;
        do {
            row = value.nextInt(3);
            col = value.nextInt(3);
        } while (!isValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);
    }
}
