import java.util.*;
public class PriorityQueue {

    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        // this is for integer type priority queue 
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        // pq.add(5);
        // pq.add(4);
        // pq.add(9);
        // pq.add(1);
        // pq.add(2);

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }

        // And this is for object type priority queue
        PriorityQueue<Student> s = new PriorityQueue<>();

        s.add(new Student("ankit", 2));
        s.add(new Student("saket ", 1));
        s.add(new Student("rishabh", 5));

        while(!s.isEmpty()){
            System.out.println(s.peek().name +"->" +s.peek().rank);
            s.remove();
        }
    }   
}
