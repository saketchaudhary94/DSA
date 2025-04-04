public class MinInRotatedSortedArr {

    public static  int findMin(int[] nums) {
        int s =0;
        int e = nums.length-1;
        int min = Integer.MAX_VALUE;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(nums[s] <= nums[e]){
                min = Math.min(min , nums[s]);
                break;
            }

            if(nums[s] <= nums[mid] ){ //. left half is sorted 
                min = Math.min(min , nums[s]);
                s = mid+1;
            }
            else{
                min = Math.min(min , nums[mid]);
                e = mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int nums[] = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
