import java.util.*;

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

    // helper function to create a bst from a merged list 
    public static Node createBST2(ArrayList<Integer> list , int s , int e){
        if(s > e){
            return null;
        }
        int mid = s + (e-s)/2;
        Node root = new Node(list.get(mid));
        root.left = createBST2(list, s, mid-1);
        root.right = createBST2(list, mid+1, e);
        return root;
    }
    // helper function for mergedBST function 
    public static void getInorder(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    // function to create a single bst of given two bst's
    public static Node mergedBST(Node root1 , Node root2){

        ArrayList<Integer> list1 = new ArrayList<>();
        getInorder(root1 , list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        getInorder(root2, list2);

        int i =0 , j=0;
        ArrayList<Integer> mergeList = new ArrayList<>();

        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) <= list2.get(j)){
                mergeList.add(list1.get(i));
                i++;
            }
            else{
                mergeList.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()){
            mergeList.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            mergeList.add(list2.get(j));
            j++;
        }
        return createBST2(mergeList , 0 , mergeList.size()-1);
    }
    public static void main(String[] args) {
        int arr1[] = {3,5,6,8};
        int arr2[] = {10,11,12};
        Node root1 = createBST(arr1, 0, arr1.length-1);
        Node root2 = createBST(arr2, 0, arr2.length-1);
        // inorder(root);
        // largestBST(root);
        // System.out.println(maxBST);
        Node mergedRoot = mergedBST(root1, root2);
        inorder(mergedRoot);
    }
}
