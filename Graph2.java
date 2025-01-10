import java.util.*;
import java.util.LinkedList;



public class Graph2 {

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

    public static void bfs(ArrayList<Edge> [] graph){
        boolean visited[] = new boolean[graph.length];

        for(int i =0;i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph , boolean visited[]){
        Queue<Integer> q = new LinkedList<>();

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

    public static void dfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        
        for(int i =0;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[] , int curr , boolean visited[]){
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i =0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    // function for detect cycle in undirected graph
    public static boolean detectCycle(ArrayList<Edge> [] graph){
        boolean visited[] = new boolean[graph.length];

        for(int i =0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtil(graph , visited , i , -1)){
                    return true;
                }
            }
        }
        return false;
    }

    // helper function for detect cycle 
    public static boolean detectCycleUtil(ArrayList<Edge> [] graph , boolean visited[] , int curr , int par){
        visited[curr] = true;

        for(int i =0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            // case 3 :
            if(!visited[e.dest]){
                if(detectCycleUtil(graph, visited, e.dest, curr)){
                    return true;
                }
            }
            // case 1:
            else if(visited[e.dest] && e.dest != par){
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
        System.out.println(detectCycle(graph));
    }
}
