
public class MosAlgorithm {

    public static int rangeQuery(int prefix[] ,int len , int arr[] , int l , int r){
        int res = 0;

        // calculating left part
        while(l % len != 0 && l < r && l!= 0){
            res += arr[l++];
        }

        // calculating middle part 
        while(l + len <= r){
            res += prefix[l / len];
            l += len;
        }

        // calculating the right one
        while(l <= r){
            res += arr[l++];
        }

        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,8,7,2,1,5,6,3};
        int len = (int)Math.sqrt(arr.length);
        int prefix[] = new int[len+1];
        int idx = -1;

        for(int i =0;i < arr.length;i++){
            if(i % len == 0) idx++;
            prefix[idx] += arr[i];
        }

        System.out.println(rangeQuery(prefix, len, arr, 1 ,2));

    }
}
