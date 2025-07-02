package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class LongestFliteRoute {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dp, parent;
    static boolean[] visited;
    static Stack<Integer> topoStack = new Stack<>();

    public static void dfs(int node) {
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei);
            }
        }
        topoStack.push(node);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        dp = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        Arrays.fill(parent, -1);

        dp[1] = 0; // start from node 1

        // Perform DFS Topological Sort
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) dfs(i);
        }

        // Process nodes in topological order
        while (!topoStack.isEmpty()) {
            int u = topoStack.pop();
            for (int v : graph.get(u)) {
                if (dp[u] != Integer.MIN_VALUE && dp[u] + 1 > dp[v]) {
                    dp[v] = dp[u] + 1;
                    parent[v] = u;
                }
            }
        }        

        if (dp[n] == Integer.MIN_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> path = new ArrayList<>();
            int curr = n;
            while (curr != -1) {
                path.add(curr);
                curr = parent[curr];
            }
            Collections.reverse(path);
            System.out.println(path.size());
            for (int node : path) {
                System.out.print(node + " ");
            }
        }
    }
}
