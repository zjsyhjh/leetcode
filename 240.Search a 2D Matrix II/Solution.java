public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }        
        return dfs(matrix, matrix.length - 1, 0, target);
    }

    private boolean dfs(int[][] matrix, int x, int y, int target) {
        if (matrix[x][y] == target) {
            return true;
        }
        if (target < matrix[x][y] && (x - 1) >= 0) {
            return dfs(matrix, x - 1, y, target);
        }
        if (target > matrix[x][y] && (y + 1) < matrix[0].length) {
            return dfs(matrix, x, y + 1, target);
        } 
        return false;
    }
}