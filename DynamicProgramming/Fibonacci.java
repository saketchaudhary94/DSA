public class Fibonacci {

    // memoization
    public static int findFibonacci(int n , int f[]){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = findFibonacci(n-1, f) + findFibonacci(n-2, f);
        return f[n];
    }

    // tabulation
    public static int findFibonacci2(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;

        for(int i =2; i <=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n =6;
        int f[] = new int[n+1];
        System.out.println(findFibonacci(n , f));
        System.out.println(findFibonacci2(n));
    }
}
