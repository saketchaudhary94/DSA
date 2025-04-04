package DynamicProgramming;
public class TargetSumSubset {
    
    public static boolean targetSumSubset(int arr[] , int target){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][target+1];

        for(int i =0;i < dp.length;i++){
            dp[i][0] = true;
        }

        for(int i =1;i < dp.length;i++){
            for(int j =1;j < dp[0].length;j++){
                int val = arr[i-1];

                // include condition 
                if(val <= j && dp[i-1][j - val] == true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int target = 10;
        System.out.println(targetSumSubset(arr, target));
    }
}
