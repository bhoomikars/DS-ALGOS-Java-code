public class Sudoku {

   public static boolean isSafe(int[][] board, int row, int col, int num){
       for(int i=0;i<board.length;i++){
           if(board[row][i] == num)
               return false;
       }

       for(int i=0;i<board[row].length;i++){
           if(board[i][col] == num)
               return false;

       }
       int s = (int)Math.sqrt(board.length);
       int rowStart = row - row%s;
       int colStart = col - col%s;
       for(int i=rowStart;i<rowStart+s;i++){
           for(int j=colStart;j<colStart+s;j++)
               if(board[i][j] == num)
                   return false;
       }
       return true;
   }


    public static boolean sudokuSolver(int board[][]){
        int row = -1;
        int col = -1;
        boolean isFilled = true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    isFilled = false;
                    break;
                }
            }
            if(!isFilled)
                break;
        }
        if(isFilled)
            return true;
        else{
            for(int num = 1;num<=9;num++){
                if(isSafe(board,row,col,num)){
                    board[row][col] = num;
                    if(sudokuSolver(board))
                        return true;
                    else
                        board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String args[])
    {

        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        int N = board.length;

        if (sudokuSolver(board))
        {
            print(board); // print solution
        }
        else
        {
            System.out.println("No solution");
        }
    }
}
