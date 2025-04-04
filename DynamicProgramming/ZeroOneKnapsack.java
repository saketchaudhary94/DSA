package DynamicProgramming;
public class ZeroOneKnapsack {

    public static int knapsack(int val[] , int wt[] , int w , int n , int dp[][]){
        
        if(w== 0 || n==0){
            return 0;
        }

        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(wt[n-1] <= w){
            // include 
            int ans1 = val[n-1] + knapsack(val, wt, w - wt[n-1], n-1 , dp);

            // exclude 
            int ans2 = knapsack(val, wt, w, n-1 , dp);

            dp[n][w] = Math.max(ans1 , ans2);
            return dp[n][w];
        }
        else{
            dp[n][w] = knapsack(val, wt, w, n-1 , dp);
            return dp[n][w];
        }
    }

    // tabulation 
    public static int knapsack2(int val[] , int wt[] , int w){
        int n = val.length;
        int dp[][] = new int[n+1][w+1];

        for(int j =0;j < dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i =0;i < dp.length;i++){
            dp[i][0] = 0;
        }

        for(int i =1;i< dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                int value = val[i-1];
                int weight = wt[i-1];

                if(weight <= j){
                    int include = value + dp[i-1][j - weight];
                    int exclude = dp[i-1][j];

                    dp[i][j] = Math.max(include , exclude);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;
        int dp[][] = new int[val.length+1][w+1];
        
        for(int i =0;i < dp.length;i++){
            for(int j =0;j < dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val, wt, w, val.length , dp));
        System.out.println(knapsack2(val, wt, w));
    }
}
