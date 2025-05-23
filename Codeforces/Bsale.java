package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bsale {

    public static int helper(int arr[] , int m){
        Arrays.sort(arr);
        int sum = 0;
        for(int i =0; i< m;i++){
            if(arr[i] < 0){
                sum += Math.abs(arr[i]);
            }
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(helper(arr, m));
    }
}
