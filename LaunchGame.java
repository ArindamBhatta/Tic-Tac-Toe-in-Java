public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.displayBoard();
        HumanPlayer p1 = new HumanPlayer("Arindam", 'X');
        ComputerPlayer p2 = new ComputerPlayer("Computer",'0');
        PlayerInterface cp;
        cp = p1;
        while (true) {
            System.out.println(cp.name + " turns");
            cp.makeMove();
            t.displayBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagonalWin()) {
                System.out.println(cp.name + " has won");   
                break;
            } else {
                cp = (cp == p1) ? p2 : p1;
            }
        }
    }
}
