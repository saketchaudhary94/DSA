
public class CircularLL {

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // function to add element at first 
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    // to insert at the end 
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // to remove first 
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty :");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        tail.next = head;
        size--;
        return val;
    }

    // to remove last 
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty :");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        for(int i = 0; i<size-2;i++){
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
        size--;
        return val;
    }

    // to print the cll 
    public void print(){
        Node temp = head;
        do { 
            System.out.print(temp.data +"->");
            temp = temp.next;
        } while (temp != head);
        System.out.println(" ");
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.addLast(4);
        cll.print();
        System.out.println(cll.removeFirst());
        System.out.println(cll.removeLast());
        cll.print();
    }
}
