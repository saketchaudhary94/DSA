package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimizingCoins {
    
    public static int minimizingCoins(int n , int ds , int arr[] , int dp[]){
        if(ds == 0) return 0;

        if(dp[ds] != -1){
            return dp[ds];
        }
        long res = Integer.MAX_VALUE;
        for(int i =0;i < n;i++){
            if(arr[i] <= ds){
                res = Math.min(res ,1 + minimizingCoins(n , ds - arr[i] , arr , dp));
            }
        }
        dp[ds] =  res == Integer.MAX_VALUE ? -1 : (int) res;
        return dp[ds];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i =0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[x+1];
        Arrays.fill(dp , -1);
        System.out.println(minimizingCoins(n , x , arr , dp));
    }
}
