package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfTwoValues {

    public static void sumOfTwoValues(int pair[][] , int x){
        int l = 0 , r = pair.length-1;

        while(l < r){
            int sum = pair[l][0] + pair[r][0];

            if(sum == x){
                System.out.print(pair[l][1]+" "+pair[r][1]);
                return;
            }
            else if(sum < x) l++;
            else r--;
        }
        System.out.println("IMPOSSIBLE");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int pair[][] = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for(int i =0;i < n;i++){
            pair[i] = new int[]{Integer.parseInt(st.nextToken()) , i+1};
        }
        Arrays.sort(pair , (a , b) -> Integer.compare(a[0], b[0]));
        sumOfTwoValues(pair, x);
    }
}
