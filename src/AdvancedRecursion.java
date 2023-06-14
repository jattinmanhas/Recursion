import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class AdvancedRecursion {
    //1. print all the paths in the maze reaching to destination if maze have an obstacle
    // Here we are keeping track of the path of the maze by making already visited path to false...
    public void obstacleMaze(boolean[][] maze, int r, int c, String path){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        if(r < maze.length-1){
            obstacleMaze(maze, r+1, c, path + "V");
        }
        if(c < maze[0].length-1){
            obstacleMaze(maze, r, c+1, path + "H");
        }
        if(r < maze.length-1 && c < maze[0].length-1){
            obstacleMaze(maze, r+1, c+1, path + "D");
        }

        maze[r][c] = true;
    }

    // 2. print path of the maze leading to the destination if we can move in all four directions.
    public void allFourDirectionsMaze(boolean[][] maze, int r, int c, String path){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;

        if(r < maze.length-1){
            allFourDirectionsMaze(maze, r+1, c, path + "D");
        }
        if(c < maze[0].length-1){
            allFourDirectionsMaze(maze, r, c+1, path + "R");
        }
        if(r > 0){
            allFourDirectionsMaze(maze, r-1, c, path + "U");
        }
        if(c > 0){
            allFourDirectionsMaze(maze, r, c-1, path + "L");
        }

        maze[r][c] = true;
    }

    // 3. N-Queens Problem (Leetcode)

    public List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(board, n, 0, ans);
        return ans;
    }

    public void solve(char[][] board, int n, int row, List<List<String>> ans){
        if(board.length == row){
            ans.add(construct(board));
            return;
        }

        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                solve(board, n, row+1, ans);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col){
        // vertical check
        for(int i = 0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //check for left diagonal
        int left = Math.min(row, col);
        for(int i = 1;i<=left;i++){
            if(board[row-i][col-i] == 'Q'){
                return false;
            }
        }

        int right = Math.min(row, board.length-col-1);
        for(int i = 1; i<=right;i++){
            if(board[row-i][col+i] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            String str = new String(board[i]);
            list.add(str);
        }
       return list;
    }
}

