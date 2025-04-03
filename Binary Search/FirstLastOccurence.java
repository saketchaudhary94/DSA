public class FirstLastOccurence {


    public static  int lowerBound(int arr[] , int x){
        int s = 0, e  = arr.length-1;
        int res = arr.length;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(arr[mid] >= x){
                res = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return res;
    }
    public static int upperBound(int arr[] , int x){
        int s = 0, e  = arr.length-1;
        int res = arr.length;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(arr[mid] > x){
                res = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        int target = 8;
        int lb = lowerBound(nums , target);
        if(lb == nums.length || nums[lb] != target){
           System.out.println("-1 , -1");
        }
        System.out.println(lb + " , " + (upperBound(nums, target) - 1));

    }
}
