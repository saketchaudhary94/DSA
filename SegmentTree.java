public class SegmentTree {

    static int tree[];

    // to build a max tree
    public static void buildTree2(int arr[] , int i , int start , int end){
        if(start == end){
            tree[i] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        buildTree2(arr, 2*i+1, start, mid);
        buildTree2(arr, 2*i+2, mid+1, end);
        tree[i] = Math.max(tree[2*i+1] , tree[2*i+2]);
    }
    
    // get max from max tree 
    public static int getMaxUtil(int i , int si , int sj , int qi , int qj){
        if(qj < si || qi > sj){
            return Integer.MIN_VALUE;
        }
        
        else if(si >= qi && sj <= qj){
            return tree[i];
        }

        else{
            int mid = (si + sj)/2;
            int left = getMaxUtil(2*i+1 , si , mid , qi , qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);

            return Math.max(left , right);
        }
    }

    public static int getMax(int arr[] , int qi , int qj){
        return getMaxUtil(0 , 0 , arr.length-1 , qi , qj);
    }


    // update the max tree
    public static void updateUtil2(int i , int si , int sj , int idx , int newVal){
        if(si == sj){
            tree[i] = newVal;
            return;
        }

        int  mid = si + (sj - si)/2;
        if(idx >= si && idx <= mid){
            updateUtil2(2*i+1, si, mid, idx, newVal);
        }
        else{
            updateUtil2(2*i+2, mid+1,sj, idx, newVal);
        }

        tree[i] = Math.max(tree[2*i+1] , tree[2*i+2]);
    }

    public static void update2(int arr[] , int idx  , int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil2(0 , 0 , n-1 , idx , newVal);
    }

    // to build a sum tree
    public static int buildTree1(int arr[] , int i , int start , int end){
        if(start == end){
            tree[i] = arr[start];
            return tree[i];
        }
        int mid = (start + end)/2;
        int left = buildTree1(arr, 2*i+1, start, mid);
        int right = buildTree1(arr, 2*i+2, mid+1, end);
        tree[i] = left + right;
        return tree[i];
    }


    // get sum from sum tree
    public static int getSumUtil(int i , int si , int sj , int qi , int qj){
        if(qj < si || qi > sj){
            return 0;
        }
        
        else if(si >= qi && sj <= qj){
            return tree[i];
        }

        else{
            int mid = (si + sj)/2;
            int left = getSumUtil(2*i+1 , si , mid , qi , qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);

            return left + right;
        }
    }

    public static int getSum(int arr[] , int qi , int qj){
        return getSumUtil(0 , 0 , arr.length-1 , qi , qj);
    }

    // update the sum tree
    public static void updateUtil(int i , int si , int sj , int idx , int diff){
        if(idx < si || idx > sj){
            return;
        }
        tree[i] += diff;

        if(si != sj){
            int mid = (si + sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }

    public static void update(int arr[] , int idx , int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n-1, idx, diff);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        tree = new int[4*n];
        // int root = buildTree(arr, 0, 0, n-1);

        // for(int i =0;i < tree.length;i++){
        //     System.out.print(tree[i] +" ");
        // }

        // System.out.println(getSum(arr , 2,5));
        // update(arr, 2, 2);
        // System.out.println(getSum(arr , 2,5));

        buildTree2(arr, 0, 0, n-1);
        System.out.println(getMax(arr, 2, 4));
    }
}
