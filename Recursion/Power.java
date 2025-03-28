package Recursion;
public class Power {

    public static int powerOfX(int x , int n){
        if(n == 0){
            return 1;
        }
        return x*powerOfX(x, n-1);
    }
    // more optimized solution :
    public static double powerOfXn(int x, int n ){
        if(n==0){
            return 1;
        }
        double half = powerOfXn(x, n/2);
        if(n % 2 == 0){
            return half*half;
        }
        else{
            return half*half*x;
        }
    }
    public static void main(String[] args) {
        System.out.println(powerOfX(2, 2));
        System.out.println(powerOfXn(2,2));
    }
}
