abstract public class PlayerInterface {
    String name;
    char mark;

    public PlayerInterface(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /*
     * place move is common between two class that why we dont want to @override or
     * implement this method that why we use final keyword final int a = 5; we can't
     * reassgin. abstract method means we definitely implement. @override
     */

    abstract void makeMove();

    public final boolean isValidMove(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            } else {
                System.err.println("already occupied");
                return false;
            }
        } else {
            System.err.println("index out of boundary");
            return false;
        }
    }
}
