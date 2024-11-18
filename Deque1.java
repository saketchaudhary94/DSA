import java.util.*;
import java.util.LinkedList;

public class Deque1 {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.addFirst(3);
        dq.addLast(0);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
    }
}
