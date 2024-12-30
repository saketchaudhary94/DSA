public class ArrtoBalaneBST {
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

    // function to create a balanced bst from an sorted arrat 
    public static Node createBst(int arr[] , int s , int e){
        if(s > e){
            return null;
        }
        int  mid = (s+e)/2;
        Node root = new Node(arr[mid]);
        root.left = createBst(arr, s, mid-1);
        root.right = createBst(arr, mid+1, e);
        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = createBst(arr, 0, arr.length-1);
        preorder(root);
    }
}
