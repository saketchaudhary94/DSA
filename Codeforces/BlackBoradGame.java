package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackBoradGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            if(n % 4 == 0){
                System.out.println("bob");
            }
            else{
                System.out.println("Alice");
            }
        }
    }
}
