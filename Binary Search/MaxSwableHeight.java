public class MaxSwableHeight {

    public static long woodCollect(int arr[] , int height){
        long totalWood = 0;

        for(int tree : arr){
            if(tree > height){
                totalWood += tree - height;
            }
        }
        return totalWood;
    }

    public static int findMaxHeight(int arr[] , int n , int m){
        int left =0;
        int right = 0;
        int bestHeight = 0;
        for(int i =0;i < n;i++){
            right = Math.max(right , arr[i]);
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            
            long currWoods = woodCollect(arr , mid);

            if(currWoods >= m){
                bestHeight = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return bestHeight;
    }
    public static void main(String[] args) {
        int arr[] = {20,15,10,17};
        int n = 4,m=7;
        System.out.println(findMaxHeight(arr, n, m));
    }
}
