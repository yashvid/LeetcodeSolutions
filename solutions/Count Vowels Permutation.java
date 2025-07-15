import java.util.Arrays;

class Solution {
    private static final int MOD = (int)1e9 + 7;
    private static final int N = 5;
    private static final int[][] MATRIX = {
        {0, 1, 0, 0, 0},  // a -> e
        {1, 0, 1, 0, 0},  // e -> a,i
        {1, 1, 0, 1, 1},  // i -> a,e,o,u
        {0, 0, 1, 0, 1},  // o -> i,u
        {1, 0, 0, 0, 0}   // u -> a
    };
    
    public int countVowelPermutation(int n) {
        if (n == 1) return 5;
        
        int[][] matrix = matrixPow(MATRIX, n - 1);
        
        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = (result + matrix[i][j]) % MOD;
            }
        }
        
        return (int)result;
    }
    
    private int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum = (sum + (long)A[i][k] * B[k][j]) % MOD;
                }
                C[i][j] = (int)sum;
            }
        }
        return C;
    }
    
    private int[][] matrixPow(int[][] matrix, int n) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }
        
        while (n > 0) {
            if ((n & 1) == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            n >>= 1;
        }
        return result;
    }
}
class SolutionAC {
    public int countVowelPermutation(int n) {
        int pre[][] = {{4,1,2},{0,2},{1,3},{2},{2,3}}, N = 5;
        long dp[] = new long[N], MOD = (long)1e9+7;
        Arrays.fill(dp, 1);
        for(int i = 1; i<n; i++){
            long t[] = new long[N];
            for(int j = 0; j<N; j++){
                for(var x : pre[j]){
                    t[j] = (t[j] + dp[x]) % MOD;
                }
            }
            dp = t;
        }
        long ans = 0;
        for(int i = 0; i<N; i++){
            ans = (ans + dp[i]) % MOD;
        }
        return (int)ans;
    }
}