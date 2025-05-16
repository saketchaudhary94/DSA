package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Commondivisors {

    public static int commonDivisor(int arr[]){
        int map[] = new int[1000001];
        
        for(int el  : arr){
            map[el]++;
        }

        for(int i =map.length-1;i >=1;i--){
            int cnt = 0;
            for(int j =i;j < map.length;j += i){
                cnt += map[j];
                if(cnt > 1){
                    return i;
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(commonDivisor(arr));
    }
}