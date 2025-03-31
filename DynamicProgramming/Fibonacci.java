public class Fibonacci {

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
    public static void main(String[] args) {
        int n =6;
        int f[] = new int[n+1];
        System.out.println(findFibonacci(n , f));
    }
}
