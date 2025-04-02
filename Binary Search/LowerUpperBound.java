public class LowerUpperBound {

    // func for lower bound 
    public static int lowerBound(int arr[] , int x){
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

    // func for upper bound 
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
        int arr[] = {1, 3, 3, 5, 7, 9};  
        int target = 3;

       System.out.println("lower bound is : " + lowerBound(arr, target));
       System.out.println("upper bound is :" +upperBound(arr, target) );
    }
}
