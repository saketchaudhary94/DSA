import java.util.Collections;
import java.util.PriorityQueue;

public class Heap2 {

    // heapify a helper function for heapsort to build a maxheap
    public static void heapify(int arr[] , int i , int size){
        int left =  2*i+1;
        int right = 2*i+2;
        int max = i;

        if(left < size && arr[left] > arr[max]){
            max = left;
        }
        if(right < size && arr[right] > arr[max]){
            max = right;
        }

        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }
    }
    // function of heap sort time complexity O(nlogn)
    public static void heapSort(int arr[]){
        // step 1   build maxheap
        int n = arr.length;
        for(int i =n/2;i >=0;i--){
            heapify(arr ,i , n);
        }

        // step 2 swap the largest to end 
        for(int i =n-1;i > 0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr , 0 , i);
        }
    }

    // function to print an array
    public static void print(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // nearby cars leetcode 973
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        int idx;

        public Point(int x , int y , int dist , int idx){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.dist - p2.dist;
        }
    }

    // gfg minimum cost of ropes 
    public static int minCostRopes(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        return cost;
    }

    // the k weakest rows in a matrix leetcode 1337
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers , int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }
            else{
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static int[] weakestRow(int mat[][] ,int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i =0;i < mat.length;i++){
            int soldiers = 0;
            for(int j = 0;j < mat[0].length;j++){
                soldiers += mat[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(soldiers, i));
        }

        int res[] = new int[k];
        for(int i =0;i < k;i++){
            res[i] = pq.remove().idx;
        }
        return res;
    }

    // question sliding window maximum leetcode 239
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }

    public static int[] windowMaximum(int arr[] , int k){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int res[] = new int[arr.length-k+1];

        // string first window in queue
        for(int i=0;i < k;i++){
            q.add(new Pair(arr[i], i));
        }
        res[0] = q.peek().val;

        for(int i =k;i<arr.length;i++){
            while(q.size() > 0 && q.peek().idx <= (i-k)){
                q.remove();
            }
            q.add(new Pair(arr[i], i));
            res[i-k+1] = q.peek().val;
        }
        return res;
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,4,5,3};
        // heapSort(arr);
        // print(arr);

        // reamin part of nearby cars 
        int pts[][] = {{3,3} , {5,-1} , {-2,4}}; 
        int k1 =2;
        PriorityQueue<Point> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<pts.length;i++){
            int dist = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], dist, i));
            if(pq.size() > k1){
                pq.remove();
            }
        }
        
        while(!pq.isEmpty()){
            System.out.print(pq.peek().dist + " ");
            pq.remove();
        }

        // int ropes[] = {4,3,2,6};
        // System.out.println(minCostRopes(ropes));

        System.out.println();

        // calling weakest row function 
        int mat[][] = {{1,0,0,0} , {1,1,1,1} , {1,0,0,0} , {1,0,0,0}};
        int k2 = 2;
        int res[] = weakestRow(mat, k2);
        print(res);

        // calling sliding window function 
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k3 = 3;
        print(windowMaximum(arr, k3));
    }
}
