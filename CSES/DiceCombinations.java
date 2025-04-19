package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceCombinations {
    static int m = 1000000007;

    // memoization code 

    // public static int diceCombinations(int n , int dp[] ){
    //     if(n == 0) return 1;
    //     if(n < 0) return 0;

    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
    //     long ways = 0;
    //     for(int i =1;i <= 6;i++){
    //         ways = (ways + diceCombinations(n-i, dp)) %m;
    //     }
    //     dp[n] =  (int) ways;
    //     return dp[n];
    // }

    // tabulation

    public static int diceCombinations2(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i =1;i <= n;i++){
            int sum = 0;
            for(int j =1;j <= 6;j++){
                if(i -j >= 0){
                    sum =  (sum + dp[i-j])%m;
                }
            }
            dp[i] = sum;
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        System.out.println(diceCombinations2(n));

    }
}
