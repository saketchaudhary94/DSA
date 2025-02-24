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
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = createBST(arr, 0, arr.length-1);
        inorder(root);
    }
}
