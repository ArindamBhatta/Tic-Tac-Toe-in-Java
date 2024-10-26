public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.displayBoard();
        HumanPlayer p1 = new HumanPlayer("Arindam", 'X');
        ComputerPlayer p2 = new ComputerPlayer("Computer", '0');
        PlayerInterface cp;
        cp = p1;
        Boolean gameOnGoing = true;
        while (gameOnGoing) {
            System.out.println(cp.name + " turns");
            cp.makeMove();
            System.out.flush();
            t.displayBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagonalWin()) {
                System.out.println(cp.name + " has won");
                gameOnGoing = false;
                break;
            }
            if (TicTacToe.checkDraw()) {
                System.out.println("Draw");
                gameOnGoing = false;
                break;
            }
            if (cp == p1) {
                cp = p2;
            } else {
                cp = p1;
            }
        }
    }
}
