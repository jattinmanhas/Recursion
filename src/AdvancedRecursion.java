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

    // 4. N-queens number of ways to insert queens
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                board[i][j] = false;
            }
        }

        int ans = nQueensPaths(0, board);
        return ans;
    }

    public int nQueensPaths(int row, boolean[][] board){
        if(row == board.length){
            return 1;
        }

        int count = 0;

        for(int col=0; col<board.length;col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += nQueensPaths( row+1,board);
                board[row][col] = false;
            }
        }

        return count;
    }

    public boolean isSafe(boolean[][] board, int row, int col){
        //check vertical
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        //check diagonal left
        int maxLeft = Math.min(row, col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        //check diagonal right
        int maxRight = Math.min(row, board.length-col-1);
        for(int i=1;i<=maxRight;i++)
        {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    //5. Palindrome Partitioning
    public List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partitionHelper(s,0 ,ans, ds);
        return ans;
    }

    public void partitionHelper(String s,int index, List<List<String>> ans, List<String> ds){
        if(s.isEmpty()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            String current = s.substring(0, i+1);
            if(CheckPalindrome(current)) {
                ds.add(current);
                partitionHelper(s.substring(i+1), index + 1, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public boolean CheckPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;

        while(start <= end) {
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

}

