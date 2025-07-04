package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FlightDiscount {

    static class Pair {
        int node;
        long cost;
        int usedCoupon;

        Pair(int node, long cost, int usedCoupon) {
            this.node = node;
            this.cost = cost;
            this.usedCoupon = usedCoupon;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read n and m
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        // Read edges
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, c});
        }

        // Dijkstra with coupon usage tracking
        long[][] dist = new long[n + 1][2]; // dist[i][0] without coupon, dist[i][1] with coupon
        for (int i = 0; i <= n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dist[1][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.offer(new Pair(1, 0, 0)); // node, cost, usedCoupon

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long currCost = curr.cost;
            int used = curr.usedCoupon;

            if (currCost > dist[u][used]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int price = edge[1];

                // Normal edge
                if (currCost + price < dist[v][used]) {
                    dist[v][used] = currCost + price;
                    pq.offer(new Pair(v, dist[v][used], used));
                }

                // Use coupon if not used
                if (used == 0) {
                    long discounted = currCost + price / 2;
                    if (discounted < dist[v][1]) {
                        dist[v][1] = discounted;
                        pq.offer(new Pair(v, discounted, 1));
                    }
                }
            }
        }

        System.out.println(dist[n][1]);
    }
}
