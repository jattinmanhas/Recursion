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

    // print path of the maze leading to the destination if we can move in all four directions.
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
}
