package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class GameRoutes {
    static ArrayList<Integer> graph[];
    static boolean visited[];
    static Stack<Integer> topo = new Stack<>();
    static int mod = 1000000007;

    public static void dfs(int curr){
        visited[curr] = true;

        for(int el : graph[curr]){
            if(!visited[el]){
                dfs(el);
            }
        }

        topo.push(curr);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n+1];
        for(int i =0;i <= n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        visited = new boolean[n+1];
        for(int i =1;i <=n;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        
        long dp[] = new long[n+1];
        dp[1] = 1;

        while(!topo.isEmpty()){
            int u = topo.pop();
            for(int el : graph[u]){
                dp[el]  = (dp[el] +  dp[u])% mod;
            }
        }

        System.out.println(dp[n]);
    }
}
