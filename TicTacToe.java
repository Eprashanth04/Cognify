import java.util.Scanner;

public class TicTacToe {
    public static void showBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    public static boolean hasWon(char[][] board, char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

    public static boolean isFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            showBoard(board);

            int r, c;
            while (true) {
                System.out.print("Player " + player + ", Enter row and column (1-3): ");
                r = s.nextInt() - 1;
                c = s.nextInt() - 1;

                if (r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == ' ') {
                    board[r][c] = player;
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            if (hasWon(board, player)) {
                showBoard(board);
                System.out.println("Player " + player + " wins!");
                gameOver = true;
            } else if (isFull(board)) {
                showBoard(board);
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                player = (player == 'X') ? 'O' : 'X';
            }
        }

        System.out.print("Play again? (Yes/No): ");
        String again = s.next();
        if (again.equalsIgnoreCase("Yes")) {
            main(args); 
        } else {
            System.out.println("Thanks for playing!");
        }

        s.close();
    }
}
