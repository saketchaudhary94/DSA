package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Omatching {
    static int[][] mat;
    static int[][] dp;
    static int n;
    static final int MOD = 1_000_000_007;

    public static int helper(int i, int mask) {
        if (i == n) return 1;  

        if (dp[i][mask] != -1) return dp[i][mask];

        int res = 0;
        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) == 0 && mat[i][j] == 1) {
                res = (res + helper(i + 1, mask | (1 << j))) % MOD;
            }
        }

        return dp[i][mask] = res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(helper(0, 0));  
    }
}
