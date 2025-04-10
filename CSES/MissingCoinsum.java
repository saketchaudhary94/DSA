import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MissingCoinsum {

    public static void missingCoinSum(long arr[]){
        long ps = 0;

        for(int i =0;i < arr.length;i++){
            if(arr[i] <= ps+1) ps += arr[i];
            else{
                System.out.println(ps+1);
                return;
            }
        }
        System.out.println(ps+1);
    }
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       long arr[] = new long[n];

       st = new StringTokenizer(br.readLine());
       for(int i =0;i < n;i++){
        arr[i] = Long.parseLong(st.nextToken());
       }

       Arrays.sort(arr);
       missingCoinSum(arr);
    }
}
