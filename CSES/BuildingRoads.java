package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildingRoads {

    static int n;
    static int m;
    static ArrayList<Integer> graph[];
    static boolean visited[];

    public static void dfs(int i ){
        visited[i] = true;
        for(int el : graph[i]){
            if(!visited[el]){
                dfs(el);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for(int i =0;i < n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i < m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u-1].add(v-1);
            graph[v-1].add(u-1);
        }

        visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0;i < n;i++){
            if(!visited[i]){
                list.add(i);
                dfs(i);
            }
        }

        int roads = list.size()-1;
        System.out.println(roads);
        for(int i =0;i < list.size()-1;i++){
            int a = list.get(i)+1;
            int b = list.get(i+1)+1;
            System.out.println(a+" "+b);
        }
    }
}
