import java.util.*;

public class Buildbst {

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right , val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);

    }

    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left , key);
        }
        else{
            return search(root.right , key);
        } 
    }

    public static Node delete(Node root , int val){
        if(root.data < val){
            root.right = delete(root.right , val);
        }
        else if(root.data > val){
            root.left = delete(root.left , val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }

            Node Is = findInorderSuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right , Is.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    // fuction to print in the range 
    public static void printInRange(Node root , int k1 , int k2){
        if(root == null){
            return;
        }

        if(root.data > k1){
            printInRange(root.left, k1, k2);
        }

        if(root.data >= k1 && root.data <= k2){
            System.out.print(root.data +" ");
        }

        if(root.data < k2){
            printInRange(root.right, k1, k2);
        }
    }

    // helper function for roottoleaf functiion 
    public static void printPath(ArrayList<Integer> path){
        for(int i =0;i<path.size();i++){
            System.out.print(path.get(i)+ "->");
        }
        System.out.println("Null");
    }

    // function to print paths from root to leaf
    public static void rootToLeaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    // function for validate bst 
    public static boolean isValidate(Node root , Node min , Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        
        if(max != null && root.data >= max.data){
            return false;
        }
        return isValidate(root.left, min, root) && isValidate(root.right, root, max);
    }

    // function to find a mirror bst 
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node leftS = mirror(root.left);
        Node rightS = mirror(root.right);

        root.left = rightS;
        root.right = leftS;
        return root;
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i =0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        // root = delete(root, 1);

        // System.out.println();
        // System.out.print(search(root, 13));
        // printInRange(root, 5, 12);
        // ArrayList<Integer> path = new ArrayList<>();
        // rootToLeaf(root, path);
        // printPath(path);
        // System.out.println(isValidate(root, null, null));
        inorder(root);
        Node mirrorN = mirror(root);
        System.out.println();
        inorder(mirrorN);
    }
}
