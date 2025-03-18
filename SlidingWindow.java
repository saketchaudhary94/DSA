public class SlidingWindow {

    // template 1 - longest subarray with sum <= k
    public static int longestSubarrayWithSumK(int arr[] , int k){
        int i = 0 ,j =0 , sum = 0;
        int maxLen = 0;

        while(j < arr.length){
            sum += arr[j];

            while(sum > k && i <= j){
                sum -= arr[i];
                i++;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen , j - i+1);
            }
            j++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {2,5,1,7,10};
        System.out.println(longestSubarrayWithSumK(arr, 14));
    }
}
