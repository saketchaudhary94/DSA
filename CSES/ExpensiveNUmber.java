package CSES;
import java.util.Scanner;
public class ExpensiveNUmber {

    public static void helper(String s){
        int n = s.length();
        int res =n-1 , lasti = 0;

        for(int i = n-1;i >=0;i--){
            if(s.charAt(i) != '0'){
                lasti = i;
                break;
            }
        }

        for(int i =0;i < lasti;i++){
            if(s.charAt(i) == '0'){
                res--;
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 

        while(t-- > 0){
            String s = sc.nextLine();
            helper(s);
        }
    }
}
