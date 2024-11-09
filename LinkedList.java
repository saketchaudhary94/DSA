// this is a whole linkedlist class 
public class LinkedList {
    
    // this is a node class 
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // add element at start of linkedlist 
    public void addFirst(int data){
        // first creating a new node of data
        Node newNode = new Node(data);
        size++;
        // check if the linkedlist is empty :
        if(head == null){
            head = tail = newNode;
            return;
        }
        // if not null :
        newNode.next = head;
        head = newNode;
    }

    // add node at last of linked list :
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail =  newNode;
    }

    // to add the element in the middle of the linkedlist :
    public void addMiddle(int idx , int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // to remove the data from beginnig of the linkedlist 
    public int removeFirst(){
        // some special cases where ll can be null or have only one node :
        if(size == 0){
            System.out.println("LinkedList is null :");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove the last node (tail) from the linkedList :
    public int removeLast(){
        if(size == 0){
            System.out.println("LinkedList is empty ");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //  iterative search for a key in linkedlist :
    public int iteSearch(int key){
        int idx =0;
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    // recursive search for a key in linkedlist :
    public int helper(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next , key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int recSearch(int key){
        return helper(head , key);
    }
    // to reverse a linkedlist by iterative :
    public void iteReverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // slow-fast appraoach to find the miidle 
    public Node findMiddle(Node head){ //  is will be the helper function 
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){ // one case is for even and second is for odd :
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; //  slow will be my middle node 
    }

    // boolean function for check that a linkedlist is palindrome or not 
    public boolean isPalindrome(){
        // base case :
        if(head == null || head.next == null){
            return true;
        }

        // use mid function to find the mid :
        Node midNode = findMiddle(head);
        // reverse the second half linkedlist :
        Node prev = null;
        Node curr = midNode;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // means right is now the head of the second nalf linked list which is reversed now 
        Node left = head; // left is the head of first half linkedlist 

        // now check whether the linked list is palindrome or not 
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Floyd's cycle finding algorithm ;
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // detect a cycle and remove it in linkedlist 
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle ==false){
            return;
        }
        slow = head;
        Node prev = null;
        
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    // getMid function to find mid for mergesort 
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge function for mergesort 
    public Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null ){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null ){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        
        return mergedLL.next;
    }
    // mergesort in linkedlist 
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // find mid 
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        // left and right ms call 
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft , newRight);
    }

    // function of zig zag linkedlist 
    public void zigzag(){
        // step 1 => to find the mid of linkedlist 
        Node slow = head;
        Node fast = head.next;
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // step 2 => reverse the linkedlist
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL , nextR;

        // step 3 => alternate merging 
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    // to print the linkedList 
    public void print(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // to change the value 
    public void change(Node head){
        head.data = 5;
    }

    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(1);
        // ll.addMiddle(0, 9);
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeLast());
        // ll.print();
        // ll.iteReverse();
        // ll.print();
        // System.out.println(size);
        // System.out.println(ll.iteSearch(3));
        // System.out.println(ll.iteSearch(2));
        // System.out.println(ll.recSearch(4));
        // System.out.println(ll.isPalindrome());
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // head.next.next.next = head;
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        
        // ll.print();
        // ll.zigzag();
        // ll.head = ll.mergeSort(ll.head);
        ll.change(head);
        ll.print();
    }
}
