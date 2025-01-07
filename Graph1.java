import java.util.*;
import java.util.LinkedList;


public class Graph1 {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // function for bfs 
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        q.add(0); // starting traversal the graph from the 0 vertex

        while(! q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i =0;i< graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // function for dfs 
    public static void dfs(ArrayList<Edge> graph[] , int curr , boolean visited[]){
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i =0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    // hash path function 
    public static boolean hashPath(ArrayList<Edge> [] graph , int src , int dest , boolean visited[]){
        if(src == dest){
            return true;
        }
        visited[src] = true;

        for(int i =0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hashPath(graph , e.dest , dest , visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);
        System.out.println(hashPath(graph, 0, 5, new boolean[V]));
    }
}
