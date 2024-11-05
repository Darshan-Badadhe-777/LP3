public class nqueens {
    public static int N = 5;
    public static int count = 0;

    public static boolean isSafe(char board[][], int row, int col) {

          // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'X')
                return false;
        }

          // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'X')
                return false;
        }

          // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'X')
                return false;
        }
        return true;
    }

    public static void solve(char board[][], int row) {
        if (row >= N) {
            print(board);
            System.out.println("Solution #" + count + ":\n");
            System.out.println();
            count++;
            return;

        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'X';
                solve(board, row + 1);
                board[row][i] = 'O';  // Backtrack
            }

        }

    }

    public static void print(char board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = new char[N][N]; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 'O';
            }
        }
        solve(board, 0);
        System.out.println("Total number of solutions: " + count);

    }
}