package CSES;

import java.util.*;

public class MissingNumber {

    public static void missingNumber(long n , long s){
        long totalSum = (n * (n+1))/2;

        System.out.print(totalSum - s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = 0;
        long n = sc.nextLong();

        for(int i =0;i < n-1;i++){
            long a = sc.nextLong();
            s += a;
        }
        missingNumber(n, s);
    }
}
