import java.util.Random;

public class ComputerPlayer extends PlayerInterface {
    private static final Random value = new Random();

    public ComputerPlayer(String name, char mark) {
        super(name, mark);
    }

    public void makeMove() {
        int row = -1;
        int col = -1;

        // First, attempt to take the center if available
        if (TicTacToe.board[1][1] == ' ') {
            row = 1;
            col = 1;
        }

        // Check for winning or blocking moves in rows
        if (row == -1) {
            for (int i = 0; i < 3; i++) {
                if (TicTacToe.board[i][0] == 'X' && TicTacToe.board[i][1] == 'X' && TicTacToe.board[i][2] == ' ') {
                    row = i;
                    col = 2;
                    break;
                }
                if (TicTacToe.board[i][0] == 'X' && TicTacToe.board[i][2] == 'X' && TicTacToe.board[i][1] == ' ') {
                    row = i;
                    col = 1;
                    break;
                }
                if (TicTacToe.board[i][1] == 'X' && TicTacToe.board[i][2] == 'X' && TicTacToe.board[i][0] == ' ') {
                    row = i;
                    col = 0;
                    break;
                }
            }
        }

        // Check for winning or blocking moves in columns
        if (row == -1) {
            for (int j = 0; j < 3; j++) {
                if (TicTacToe.board[0][j] == 'X' && TicTacToe.board[1][j] == 'X' && TicTacToe.board[2][j] == ' ') {
                    row = 2;
                    col = j;
                    break;
                }
                if (TicTacToe.board[0][j] == 'X' && TicTacToe.board[2][j] == 'X' && TicTacToe.board[1][j] == ' ') {
                    row = 1;
                    col = j;
                    break;
                }
                if (TicTacToe.board[1][j] == 'X' && TicTacToe.board[2][j] == 'X' && TicTacToe.board[0][j] == ' ') {
                    row = 0;
                    col = j;
                    break;
                }
            }
        }

        // Check for winning or blocking moves in diagonals
        if (row == -1) {
            if (TicTacToe.board[0][0] == 'X' && TicTacToe.board[1][1] == 'X' && TicTacToe.board[2][2] == ' ') {
                row = 2;
                col = 2;
            } else if (TicTacToe.board[1][1] == 'X' && TicTacToe.board[2][2] == 'X' && TicTacToe.board[0][0] == ' ') {
                row = 0;
                col = 0;
            }
        }

        // Fallback to a random move if no strategic move was found
        if (row == -1 || col == -1) {
            do {
                row = value.nextInt(3);
                col = value.nextInt(3);
            } while (!isValidMove(row, col));
        }

        // Place mark once a valid move is determined
        TicTacToe.placeMark(row, col, mark);
    }
}
