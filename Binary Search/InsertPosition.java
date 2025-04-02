public class InsertPosition {

    public static  int searchInsert(int[] nums, int target) {
        int s = 0 , e = nums.length-1;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
