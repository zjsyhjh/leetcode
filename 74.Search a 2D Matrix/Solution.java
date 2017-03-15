public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return dfs(matrix, matrix.length - 1, 0, target); 
    }

    private boolean dfs(int[][] matrix, int x, int y, int target) {
        if (matrix[x][y] == target) {
            return true;
        }
        
        if (matrix[x][y] > target && check(x - 1, y, matrix)) {
            return dfs(matrix, x - 1, y, target);            
        }

        if (matrix[x][y] < target && check(x, y + 1, matrix)) {
            return dfs(matrix, x, y + 1, target);
        }
        return false;
    }

    private boolean check(int x, int y, int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}