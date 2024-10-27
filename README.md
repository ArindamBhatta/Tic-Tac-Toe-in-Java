## Tic-Tac-Toe Game

This README file provides an overview of the Tic-Tac-Toe game implementation.

### Tic-Tac-Toe Class

The `TicTacToe` class represents the core logic of the game.

**Properties:**

- `board`: A character array of size `3x3` to store the game board state. Initially it's stote null, after null replace with empty spaces (e.g., ' ').

**Constructor:**

- Initializes the `board` property to an empty character array.

**Methods:**

- `initBoard()`: Fills the `board` array with empty spaces.
- `displayBoard()`: Prints the current state of the game board to the console.
- `static placeMark(row, col, playerMark)`: Places a player's mark (`playerMark`) at the specified row and column position on the board. This method can be called directly without creating an instance of the `TicTacToe` class.
- `static checkRowWin(row, playerMark)`: Checks if a player has won by filling a row with their mark.
- `static checkColumnWin(col, playerMark)`: Checks if a player has won by filling a column with their mark.
- `static checkDiagonalWin(playerMark)`: Checks if a player has won by filling either diagonal with their mark.

### Player Interface Class

The `Player` interface defines a common set of functionalities for both Human and Computer players.

**Properties:**

- `name`: The player's name (e.g., "Human", "Computer").
- `mark`: The player's mark used on the game board (e.g., 'X', 'O').

**Constructor:**

- Initializes the `name` and `mark` properties with provided values.

**Method:**

- `makeMove()`: An abstract method that each player class must implement to define their specific move-making logic.

### Human Player Class

The `HumanPlayer` class extends the `Player` interface and represents a human player.

**Properties:**

- `scanner`: A `Scanner` object used to get user input for their moves.

**Constructor:**

- Inherits `name` and `mark` from the `Player` interface.
- Initializes the `scanner` object.

**Method:**

- `makeMove(TicTacToe game)`: Prompts the user for a valid row and column, and then calls the `TicTacToe.placeMark()` method to place their mark on the board. This method loops until the user enters a valid move.

### LaunchGame Class

The `LaunchGame` class serves as the entry point for the game.

**Method:**

- `main()`:
    - Creates an instance of the `TicTacToe` class.
    - Initializes the `board` and calls `initBoard()` on the `TicTacToe` instance.
    - Creates instances of the `HumanPlayer` and `ComputerPlayer` classes (assuming the `ComputerPlayer` class is implemented).
    - Sets the `currentPlayer` reference to the `HumanPlayer` instance initially.
    - Enters a game loop that continues until the game is over (winning condition met or draw):
        - Calls the `currentPlayer.makeMove()` method to have the current player make their move.
        - Calls the `TicTacToe.displayBoard()` method to display the updated game board.
        - Checks for a win or draw using the `TicTacToe.checkRowWin()`, `TicTacToe.checkColumnWin()`, and `TicTacToe.checkDiagonalWin()` methods (implementation details omitted).
        - Swaps the `currentPlayer` reference between `HumanPlayer` and `ComputerPlayer` for the next turn.

