public class LowerBound {

    // floor in a sorted array gfg pratice
    public static int floor(int arr[] , int x){
        int s =0 , e = arr.length-1;
        int res = -1;

        while(s <= e){
            int mid  = s + (e -s)/2;

            if(arr[mid] <=  x){
                res  = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int x = 11;
        System.out.println(floor(arr, x));
    }
}
