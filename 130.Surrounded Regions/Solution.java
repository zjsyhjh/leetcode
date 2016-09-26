import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private boolean[][] mark;
	private int row, col;
	private int[][] dir = {
		{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};
    public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		row = board.length;
		col = board[0].length;
		mark = new boolean[row][col];

		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O') {
				bfs(board, 0, i);
			}
		}
		for (int i = 0; i < col; i++) {
			if (board[row - 1][i] == 'O') {
				bfs(board, row - 1, i);
			}
		}
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
		}
		for (int i = 0; i < row; i++) {
			if (board[i][col - 1] == 'O') {
				bfs(board, i, col - 1);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mark[i][j]) {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
    }

    private void bfs(char[][] board, int x, int y) {
    	Queue<Pos> que = new LinkedList<Pos>();
    	que.add(new Pos(x, y));
    	while (!que.isEmpty()) {
    		Pos pos = que.peek();
    		que.poll();
    		mark[pos.x][pos.y] = true;
    		for (int i = 0; i < 4; i++) {
    			int xx = pos.x + dir[i][0];
    			int yy = pos.y + dir[i][1];
    			if (check(board, xx, yy) && !mark[xx][yy]) {
    				mark[xx][yy] = true;
    				que.offer(new Pos(xx, yy));
    			}
    		}
    	}
    }

    private boolean check(char[][] board, int x, int y) {
    	if (x < 0 || x >= row || y < 0 || y >= col) {
    		return false;
    	}
    	if (board[x][y] == 'X') {
    		return false;
    	}
    	return true;
    }

    class Pos {
    	public int x, y;
    	public Pos(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}