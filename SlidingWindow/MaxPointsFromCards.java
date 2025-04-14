package SlidingWindow;
public class MaxPointsFromCards {

    public static int maxPointsObtainedFromCards(int arr[] ,int  k){
        int leftSum = 0 , rightSum = 0 , maxSum = 0;

        for(int i =0;i < k;i++){
            leftSum += arr[i];
        }
        maxSum = leftSum;
        int rightIdx = arr.length-1;

        for(int i =k-1;i >=0;i--){
            leftSum -= arr[i];
            rightSum += arr[rightIdx--];

            maxSum = Math.max(maxSum , leftSum + rightSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxPointsObtainedFromCards(arr , k));
    }
}
