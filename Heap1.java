import java.util.*;
public class Heap1 {

    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data){
            // insert at last 
            list.add(data);
            // fix heap
            int child = list.size() -1;
            int par = (child - 1)/2;

            while(list.get(child) < list.get(par)){ // O(logn)
                int temp = list.get(child);
                list.set(child , list.get(par));
                list.set(par , temp);

                child = par;
                par = (child-1)/2;
            }
        }

        public int peek(){ // O(1)
            return list.get(0);
        }

        // helper function to fix the heap name heapify 
        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2 * i + 2;
            int min = i;

            if(left < list.size() && list.get(left) < list.get(min)){
                min  = left;
            }
            if(right < list.size() && list.get(right) < list.get(min)){
                min = right;
            }

            if(min != i){
                int temp = list.get(i);
                list.set(i , list.get(min));
                list.set(min , temp);

                heapify(min);
            }
        }

        public int remove(){
            int data = list.get(0);
            // step 1 is swap 1st to last 
            int temp = list.get(0);
            list.set(0 , list.get(list.size()-1));
            list.set(list.size()-1 , temp);
            
            // step 2 is to remove last element from the list
            list.remove(list.size()-1);

            // step 3 is to fix the heap 
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
