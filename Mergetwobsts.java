import java.util.*;

public class Mergetwobsts {

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

    public static void getInorder(Node root1 , ArrayList<Integer> list1){
        if(root1 == null){
            return;
        }
        getInorder(root1.left, list1);
        list1.add(root1.data);
        getInorder(root1.right, list1);
    }

    public static Node buildBst(ArrayList<Integer> list3 , int s , int e){
        if(s > e){
            return null;
        }
        int mid = (s + e)/2;

        Node root = new Node(list3.get(mid));
        root.left = buildBst(list3, s, mid-1);
        root.right = buildBst(list3, mid+1, e);
        return root;
    }

    public static Node mergeBsts(Node root1 , Node root2){
        ArrayList<Integer> list1 = new ArrayList<>();
        getInorder(root1 , list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        getInorder(root2 , list2);

        int i=0;
        int j =0;
        
        ArrayList<Integer> list3 = new ArrayList<>();
        while(i < list1.size() && i < list2.size()){
            if(list1.get(i) <= list2.get(j)){
                list3.add(list1.get(i));
                i++;
            }
            else{
                list3.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()){
            list3.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            list3.add(list2.get(j));
            j++;
        }

        return buildBst(list3 , 0  , list3.size()-1);
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
        
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node mergeRoot = mergeBsts(root1, root2);
        inorder(mergeRoot);
    }
}
