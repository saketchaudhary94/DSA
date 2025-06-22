package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubarraySum2 {

    public static long helper(int arr[], int x){
        HashMap<Long , Long> map = new HashMap<>();
        map.put(0L , 1L);

        long sum =0 , cnt= 0;
        for(int j =0;j < arr.length;j++){
            sum  += arr[j];

            if(map.containsKey(sum - x)){
                cnt += map.get(sum - x);
            }

            map.put(sum , map.getOrDefault(sum, 0L)+1);
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
