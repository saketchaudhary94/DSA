public class SearchRotatedArr2 {

    public static boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[s] == nums[mid] && nums[mid] == nums[e]){
                s++;
                e--;
                continue;
            }

            if(nums[s] <= nums[mid]){
                if(nums[s] <= target && target < nums[mid]){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[e]){
                    s = mid+1;
                }
                else{
                    e = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));
    }
}
