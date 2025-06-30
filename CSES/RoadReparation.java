package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadReparation {

    static int par[];
    static int rank[];
    
    public static int find(int x){
        if(x == par[x]){
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static boolean union(int x , int y){
        int parX = find(x);
        int parY = find(y);

        if(parX == parY){
            return false;
        }
        int rankX = rank[parX];
        int rankY = rank[parY];

        if(rankX > rankY){
            par[parY] = parX;
        }
        else if(rankY > rankX){
            par[parX] = parY;
        }
        else{
            par[parX] = parY;
            rank[parY]++;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        par = new int[n+1];
        rank = new int[n+1];

        int edges[][] = new int[m][3];

        for(int i =0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = c; // which is cost
        }

        Arrays.sort(edges , (a , b)-> a[2] - b[2]);

        for(int i =0;i <=n;i++){
            par[i] = i;
        }
        int cnt = 0;
        long cost = 0;
        
        for(int edge[] : edges){
            if(union(edge[0] , edge[1])){
                cost += edge[2];
                cnt++;
            }
        }

        if(cnt == n-1){
            System.out.println(cost);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
