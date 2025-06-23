package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeSumQueries {

    public static long getVal(long arr[] , int l , int r){
        return l == 0 ? arr[r] : arr[r] - arr[l-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long arr[] = new long[n];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i =1;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i < q;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(getVal(arr , l-1 , r-1)).append('\n');
        }

        System.out.println(sb);
    }
}
