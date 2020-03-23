class Solution {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length,cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0,prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j],prev),dp[j-1]) + 1;
                }
                prev = temp;
            }
        }
        return dp[0];
    }
}