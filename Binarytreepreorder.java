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

        // iterative func to print kth level of a tree
        public static void kthLevel(Node root , int k){
            if(root == null){
                System.out.println("Tree is empty");
                return;
            }

            Queue<Node> q = new LinkedList<>();
            int level = 1;
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                        level++;
                    }
                }
                else{
                    if(level == k){
                        System.out.print(currNode.data + " ");
                    }
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        // recursive func to print kth level of a binary tree
        public static void kLevel(Node root , int level , int k){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data + " ");
            }

            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }

        // helper function for the func lca
        public static boolean getPath(Node root , int n , ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }

            boolean foundLeft = getPath(root.left , n , path);
            boolean foundRight = getPath(root.right, n, path);

            if(foundLeft || foundRight){
                return true;
            }

            path.remove(path.size()-1);
            return false;
        }

        // func to find lowest common ancestor
        public static Node lca(Node root , int n1 , int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root , n1 , path1);
            getPath(root , n2 , path2);

            int i =0;
            for(; i<path1.size() && i <path2.size();i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            return path1.get(i-1);
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

        /*
                        1
                       /  \
                      2    3
                     / \   / \
                    4   5 6   7
         */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // System.out.println(tree.isSubtree(root, subRoot));
        // tree.topView(root);
        // tree.kthLevel(root, 3);
        // System.out.println();
        // tree.kLevel(root, 1, 3);

        System.out.println(tree.lca(root, 4, 5).data);
    }
}
