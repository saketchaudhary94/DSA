import java.util.*;
import java.util.LinkedList;

public class Stackdeque {
    
    static class Stack{
        Deque<Integer> d = new LinkedList<>();

        public void push(int data){
            d.addLast(data);
        }

        public int pop(){
            return d.removeLast();
        }

        public int peek(){
            return d.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println( "peek element is : "+ s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
       
    }
}
