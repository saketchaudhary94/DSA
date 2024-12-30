public class Largestbstinbt {

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    // class info
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST , int size , int min , int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // var to store the ans 
    public static int largestSize = 0;

    // function to find the the largest binary search tree in a binary tree
    public static Info largestBst(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftS = largestBst(root.left);
        Info rightS = largestBst(root.right);

        int size = leftS.size + rightS.size + 1;
        int min = Math.min(root.data , Math.min(leftS.min , rightS.min));
        int max = Math.max(root.data , Math.max(leftS.max , rightS.max));

        if(root.data <= leftS.max || root.data >= rightS.min){
            return new Info(false , size , min , max);
        }

        if(leftS.isBST && rightS.isBST){
            largestSize = Math.max(largestSize, size);
            return new Info(true , size , min , max);
        }

        return new Info(false , size , min , max);
    }

    public static void main(String[] args) {
         // Constructing the given Binary Tree (BT)
         Node root = new Node(50);
         root.left = new Node(30);
         root.left.left = new Node(5);
         root.left.right = new Node(20);
 
         root.right = new Node(60);
         root.right.left = new Node(45);
         root.right.right = new Node(70);
         root.right.right.left = new Node(65);
         root.right.right.right = new Node(80);

         Info info = largestBst(root);
         System.out.println(largestSize);
    }
}
