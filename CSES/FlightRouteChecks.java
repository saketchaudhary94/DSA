package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FlightRouteChecks {

    static boolean visited[];

    public static void dfs(int curr , ArrayList<Integer> graph[]){
        visited[curr] = true;
        for(int el : graph[curr]){
            if(!visited[el]){
                dfs(el , graph);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> graph[] = new ArrayList[n+1];
        ArrayList<Integer> rev[] = new ArrayList[n+1];

        for(int i =1;i <=n;i++){
            graph[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for(int i =0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int u  = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            rev[v].add(u);
        }

        visited = new boolean[n+1];
        dfs(1 , graph);
        for(int i =1;i <= n;i++){
            if(!visited[i]){
                System.out.println("NO");
                System.out.println("1 " + i);
                return;
            }
        }

        visited = new boolean[n+1];
        dfs(1 , rev);

        for(int i =1;i <= n;i++){
            if(!visited[i]){
                System.out.println("NO");
                System.out.println(i + " 1");
                return;
            }
        }

        System.out.println("YES");
    }
}
