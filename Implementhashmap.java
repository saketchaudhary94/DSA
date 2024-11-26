import java.util.*;
import java.util.LinkedList;

public class Implementhashmap {
    static class HashMap<K,V>{
        // class for node in bucket
        private class Node{
            K key;
            V value;

            public Node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n
        private int N;
        private LinkedList<Node> buckets[]; // N

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i =0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i =0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;
            for(int i=0;i<N;i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j =0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key , node.value);
                }
            }
        }

        public void put(K key , V value){
            int bi = hashFunction(key); 
            int di = searchInLL(key, bi);
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value  = value;
            }
            else{
                buckets[bi].add(new Node(key , value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                return true;
            }
            else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                return buckets[bi].get(di).value;
            }
            else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(LinkedList<Node> ll : buckets){
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India" , 100);
        hm.put("China" , 150);
        hm.put("US" , 50);
        hm.put("Nepal" , 1);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("China"));
        System.out.println(hm.get("China"));
    }
}
