import java.util.LinkedList;
import java.util.Queue;

public class StackQ {

    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // is empty 
        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        // push 
        public static void push(int data){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        // pop 
        public static int pop(){
            if(q1.isEmpty()){
                return -1;
            }
            return q1.remove();
        }

        // peek
        public static int peek(){
            return q1.peek();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
