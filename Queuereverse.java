import java.util.*;
import java.util.LinkedList;

public class Queuereverse {

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        reverse(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove()+ " ");
        // }
        // System.out.println(q);
    }
}
