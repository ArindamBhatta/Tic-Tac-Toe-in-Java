public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.displayBoard();
        HumanPlayer playerOne = new HumanPlayer("Arindam", 'X');
        ComputerPlayer playerTwo = new ComputerPlayer("Computer", '0');
        PlayerInterface currentPlayer;
        currentPlayer = playerOne;
        Boolean gameOnGoing = true;
        while (gameOnGoing) {
            System.out.println(currentPlayer.name + " turns");
            currentPlayer.makeMove();
            game.displayBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagonalWin()) {
                System.out.println(currentPlayer.name + " has won");
                gameOnGoing = false;
                break;
            }
            if (TicTacToe.checkDraw()) {
                System.out.println("Draw");
                gameOnGoing = false;
                break;
            }
            if (currentPlayer == playerOne) {
                currentPlayer = playerTwo;
            } else {
                currentPlayer = playerOne;
            }
        }
    }
}
