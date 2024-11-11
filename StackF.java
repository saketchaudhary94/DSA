import java.util.*;

// using stack by java framework 
public class StackF {

    // question => push the data at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(4);
            return;
        }
        int val = s.pop();
        pushAtBottom(s, data);
        s.push(val);
    }

    // qustion => revere a string using stack 
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }

    // push at bottom for reverse function 
    public static void pushBottom(Stack<Integer> s , int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        pushBottom(s, val);
        s.push(top);
    }

    // function to reverse a stack 
    public static void reverseRecursion(Stack<Integer> s ){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseRecursion(s);
        pushBottom(s, top);

    }

    // function to reverse a stack by taking another empty stack and return reverse stack 
    public static Stack<Integer> reverse(Stack<Integer> s){
        Stack<Integer> newS = new Stack<>();
        while(!s.isEmpty()){
            newS.push(s.pop());
        }
        return newS;
    }

    // to print the stack
    public static void print(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // int data = 4;

        // reverseRecursion(s);
        // print(reverse(s));
        // pushAtBottom(s , data);

        // String s = "abc";
        // System.out.println(reverseString(s));

        print(s);
    }
}
