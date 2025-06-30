package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeSumQueries2 {

    static long prefix[];
    static long arr[];
    static int len;
    public static long rangeQuery(int l , int r){
        long res = 0;

        // calculating left part
        while(l % len != 0 && l < r){
            res += arr[l++];
        }

        // calculating middle part 
        while(l + len <= r){
            res += prefix[l / len];
            l += len;
        }

        // calculating the right one
        while(l <= r){
            res += arr[l++];
        }

        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        len = (int) Math.sqrt(n);
        prefix = new long[n / len + 1];
        int idx = -1;
        for(int i =0;i < arr.length;i++){
            if(i % len == 0) idx++;
            prefix[idx] += arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i < q;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(rangeQuery(l-1, r-1)).append('\n');
        }

        System.out.println(sb);
    }
}
