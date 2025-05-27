package com.leetcode;

public class Leetcode130 {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        //traverse the border and do dfs
        //upper boundary
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                dfs(0, i, board);
        }
        //lower boundary
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O')
                dfs(m - 1, i, board);
        }
        //left boundary
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);
        }
        //right boundary
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O')
                dfs(i, n - 1, board);
        }

        //replace V with O, and O with X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 'X')
            return;

        if (board[r][c] == 'V')
            return;

        board[r][c] = 'V';

        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}
