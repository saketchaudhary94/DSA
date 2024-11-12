import java.util.*;
import java.util.LinkedList;

public class Queuedeque {

    static class Queue{
        Deque<Integer> d = new LinkedList<>();

        public void add(int data){
            d.addLast(data);
        }

        public int remove(){
            return d.removeFirst();
        }

        public int peek(){
            return d.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek -" + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
