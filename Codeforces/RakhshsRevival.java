package Codeforces;
import java.util.Scanner;

public class RakhshsRevival {

    public static void helper(String s , int m, int k){
        int res = 0, cnt = 0;
        int i =0;

        while(i < s.length()){
            if(s.charAt(i) == '0'){
                cnt++;

                if(cnt == m){
                    res++;
                    i = i+k-1;
                    cnt = 0;
                }
            }
            else{
                cnt = 0;
            }
            i++;
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine(); 
            String s = sc.nextLine();
            helper(s, m, k);
        }
    }
}
