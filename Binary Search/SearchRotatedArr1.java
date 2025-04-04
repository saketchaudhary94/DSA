public class SearchRotatedArr1 {

    public static int search(int arr[] , int target){
        int s = 0 , e = arr.length-1;

        while(s <= e){
            int mid = s + (e - s)/2;

            // first half is sorted 
            if(arr[mid] == target){
                return mid;
            }

            if(arr[s] <= arr[mid]){
                if(arr[s] <= target && target < arr[mid]){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            else{
                if(arr[mid] < target && target <= arr[e]){
                    s = mid+1;
                }
                else{
                    e = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(arr, target));
    }
}
