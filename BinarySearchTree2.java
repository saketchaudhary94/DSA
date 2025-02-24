public class BinarySearchTree2 {
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

    // funtion sorted array to balanced binary search tree 
    public static Node createBST(int arr[] , int s , int e){
        if(s > e){
            return null;
        }
        int mid = s + (e-s)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, s, mid-1);
        root.right = createBST(arr, mid+1, e);
        return root;
    } 

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // largest binary search tree in a binary tree 
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
    static int maxBST = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        int size = left.size + right.size + 1;
        int min = Math.min(root.data , Math.min(left.min , right.min));
        int max = Math.max(root.data , Math.max(left.max , right.max));
        
        if(left.max >= root.data || right.min <= root.data){
            return new Info(false, size, min, max);
        }
        if(left.isBST && right.isBST){
            maxBST = Math.max(maxBST , size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = createBST(arr, 0, arr.length-1);
        // inorder(root);
        largestBST(root);
        System.out.println(maxBST);
    }
}
