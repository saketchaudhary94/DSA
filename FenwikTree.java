import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FenwikTree {

    static int n;
    static long[] tree;
    static long[] arr;

    public static void buildTree(int i, long val) {
        i++;
        while (i <= n) {
            tree[i] += val;
            i += (i & -i);
        }
    }

    public static void updateTree(int i, long newVal) {
        long diff = newVal - arr[i];
        arr[i] = newVal;
        i++;
        while (i <= n) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    public static long rangeSum(int i) {
        long res = 0;
        i++;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            buildTree(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long newVal = Long.parseLong(st.nextToken());
                updateTree(idx, newVal);
            } else {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                long sum = (a == 0) ? rangeSum(b) : rangeSum(b) - rangeSum(a - 1);
                sb.append(sum).append('\n');
            }
        }

        System.out.print(sb);
    }
}
