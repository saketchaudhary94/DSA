public class MaxConsecutiveOnes {

    public static int maxConsecutiveOnes(int nums[] , int k){
        int maxLen = 0;
        int cntZero = 0;
        int i =0 , j =0;

        while(j < nums.length){
            if(nums[j] == 0){
                cntZero++;
            }
            while(i <= j && cntZero > k){
                if(nums[i] == 0) cntZero--;
                i++;
            }
            maxLen = Math.max(maxLen , j - i+1);
            j++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(maxConsecutiveOnes(arr , k));
    }
}
