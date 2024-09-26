package org.lsh;


import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j + 1 < n && i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                } else if (j + 1 < n) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (i + 1 < m) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else {
                    dp[i][j] += grid[i][j];
                }
            }
        }
        return dp[0][0];
    }


    @Test
    public void testMain() {
        int[][] num = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(num));
    }

    public static void main(String[] args) {
    }
}
