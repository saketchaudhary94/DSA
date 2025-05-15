package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Countingdivisors {

    public static int helper(int n){
        int res = 1;

        for(int i =2;i*i <= n;i++){
            int cnt = 0;
            if(n % i == 0){
                while(n %i == 0){
                    cnt++;
                    n = n/i;
                }
                res *= (cnt+1);
            }
        }
        if(n != 1) res *= 2;
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            System.out.println(helper(x));
        }
    }
}
