package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FactoryMachines {

    public static boolean isPossible(long arr[] , long mid , long t){
        long sum = 0;

        for(int i =0;i < arr.length;i++){
            sum +=  mid/arr[i];

            if(sum >= t) return true;
        }
        return false;
    }

    public static void factoryMachines(long arr[] , long t){
        long s = 1, e = Arrays.stream(arr).max().getAsLong() * t;
        long ans = 0;

        while(s <= e){
            long mid =  s + (e - s)/2;

            if(isPossible(arr , mid , t)){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws  IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       long t = Long.parseLong(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        factoryMachines(arr, t);
    }
}
