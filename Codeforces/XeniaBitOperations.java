package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XeniaBitOperations {

    static int tree[];
    static int arr[];

    public static void buildTree(int arr[] ,int i , int si , int sj , int level){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj - si)/2;
        buildTree(arr, 2*i+1, si, mid , level-1);
        buildTree(arr, 2*i+2, mid+1, sj, level-1);

        if(level % 2 == 1){
            tree[i] = tree[2*i+1] | tree[2*i+2];
        }
        else{
            tree[i] = tree[2*i+1] ^ tree[2*i+2];
        }
    }

    public static void update(int i , int si , int sj , int idx , int newVal, int level){
        if(si == sj){
            arr[idx] = newVal;
            tree[i] = newVal;
            return;
        }

        int mid = si + (sj - si)/2;
        if(idx >= si && idx <= mid){
            update(2*i+1, si, mid, idx, newVal, level-1);
        }
        else{
            update(2*i+2, mid+1, sj, idx, newVal, level-1);
        }

        if(level % 2 == 1){
            tree[i] = tree[2*i+1] | tree[2*i+2];
        }
        else{
            tree[i] = tree[2*i+1] ^ tree[2*i+2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[1 << n];
        
        st = new StringTokenizer(br.readLine());
        for(int i =0;i < arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[4 * arr.length];
        buildTree(arr , 0  , 0 , arr.length -1, n);
        
        StringBuilder sb = new StringBuilder();
        for(int i =0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            update(0, 0, arr.length-1,p-1, b, n);
            sb.append(tree[0]).append('\n');
        }

        System.out.println(sb);
    }
}
