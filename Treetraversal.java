import java.util.*;
import java.util.LinkedList;


public class Treetraversal {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data  =data;
            this.left = null;
            this.right = null;
        }
    }

    static class Preordertree{
        static int idx = -1;
        public static Node buildPreorder(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildPreorder(nodes);
            newNode.right = buildPreorder(nodes);
            return newNode;
        }
         // preorder traversal in a tree 
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        
        // inorder traversal in a  tree 
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // postorder tree traversal 
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data +" ");
        }

        // leverl order tree traversal 
        public static void levelorder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q =  new LinkedList<>();
            
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println("");
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        // height of a subtree :
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            int height = Math.max(lh , rh) +1;
            return height;
        }

        // count of nodes in a binary tree 
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int lc = countNodes(root.left);
            int rc = countNodes(root.right);
            int count = (lc + rc)+1;
            return count;
        }
        
        // sum of nodes in a binary tree 
        public static int nodesSum(Node root){
            if(root == null){
                return 0;
            }
            int ls = nodesSum(root.left);
            int rs = nodesSum(root.right);
            return ls + rs + root.data;
        }

        // diameter of a tree O(n^2)
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int ld = diameter(root.left);
            int rd = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int selfD = lh + rh + 1;
            return Math.max(selfD , Math.max(ld , rd));
        }

        // second approach for diameter O(n)
        static class info{
            int diam;
            int ht;

            public info(int diam , int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static info diameter2(Node root){
            if(root == null){
                return new info(0 , 0);
            }

            info linfo = diameter2(root.left);
            info rinfo = diameter2(root.right);
            int diam = Math.max(Math.max(linfo.diam , rinfo.diam) , linfo.ht + rinfo.ht +1);
            int ht = Math.max(linfo.ht , rinfo.ht)+1;
            return new info(diam , ht);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4 ,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Preordertree tree = new Preordertree();
        Node root = tree.buildPreorder(nodes);
        // tree.preorder(root);
        // System.out.println("");
        // tree.inorder(root);
        // System.out.println("");
        // tree.postorder(root);
        // System.out.println("");
        // tree.levelorder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.nodesSum(root));
        System.out.println(tree.diameter2(root).diam);

    }
}
