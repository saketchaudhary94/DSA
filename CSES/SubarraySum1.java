package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubarraySum1 {

    public static int helper(int arr[] , int x){
        int i =0, j =0 , sum = 0, cnt =0;

        while(j < arr.length){
            sum += arr[j];

            while(sum > x){
                sum -= arr[i];
                i++;
            }

            if(sum == x){
                cnt++;
            }
            j++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(helper(arr , x));
    }
}
