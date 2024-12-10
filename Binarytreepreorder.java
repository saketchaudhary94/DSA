import java.util.*;
import java.util.LinkedList;

public class Binarytreepreorder {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binarytree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // helper function for issubtree funtion 
        public static boolean isIdentical(Node root , Node subRoot){
            if(root == null && subRoot == null){
                return true;
            }
            else if(root == null || subRoot == null || root.data != subRoot.data){
                return false;
            }

            if(!isIdentical(root.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(root.right, subRoot.right)){
                return false;
            }
            return true;
        }

        // function to check subtree in a tree 
        public static boolean isSubtree(Node root , Node subRoot){
            if(root == null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root , subRoot)){
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        static class Info{
            Node node;
            int hd;

            public Info(Node node , int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root){
            int min =0 , max =0;
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer , Node> map = new HashMap<>();

            q.add(new Info(root , 0));
            q.add(null);

            while(!q.isEmpty()){
                Info curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd , curr.node);
                    }
    
                    if(curr.node.left != null){
                        q.add(new Info(curr.node.left , curr.hd-1));
                        min = Math.min(min , curr.hd-1);
                    }
    
                    if(curr.node.right != null){
                        q.add(new Info(curr.node.right , curr.hd+1));
                        max = Math.max(max , curr.hd+1);
                    }
                }
            }
            for(int i =min;i<= max;i++){
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int nodes[] = {1,2,4 ,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree tree = new Binarytree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // System.out.println(tree.isSubtree(root, subRoot));
        tree.topView(root);
    }
}
