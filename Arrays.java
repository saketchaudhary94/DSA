
public class Arrays {
    // linear search func 
    public static int linearSearch(int arr[] , int key){
        for(int i =0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    // function to find the largest num
    public static int largest(int arr[]){
        int largest = Integer.MIN_VALUE;

        for(int i =0;i<arr.length;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    // binary search 
    public static int binarySearch(int arr[] , int key){
        int s = 0;
        int e = arr.length-1;

        while(s <=  e){
            int mid = s + (e - s)/2;

            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return -1;
    }

    //  recursive function of binary search 
    public static int binarySearch2(int arr[] , int s , int e , int key){
        if(s > e){
            return -1;
        }
        int mid = s + (e-s)/2;
        if(arr[mid] == key){
            return mid;
        }
        if(arr[mid] < key){
            return binarySearch2(arr, s, mid-1, key);
        }
        else{
            return binarySearch2(arr, mid+1, e, key);
        }
    }

    // max subarray sum brute force approach 
    public static void maxSubSum(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            for(int j = i;j<arr.length;j++){
                for(int k = i; k <= j ;k++){
                    currSum += arr[k]; 
                }
                maxSum = Math.max(maxSum, currSum);
                currSum = 0;
            }
        }
        System.out.println("max subarray sum is :"+ maxSum);
    }

    // kadane's algorithm to find the maximum subarray sum 
    public static int kadanes(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i =0;i<arr.length;i++){
            currSum += arr[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(currSum , maxSum);
        }
        return maxSum;
    }

    // function to find the trapping rainwater 
    public static int trappingRainwater(int height[]){
        // first calculate leftMax for every height[i]
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i =1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        }

        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }

        int trappedRainwater = 0;
        for(int i =0;i<height.length;i++){
            int waterLevel = Math.min(leftMax[i] , rightMax[i]);
            trappedRainwater += waterLevel - height[i];
        }
        return trappedRainwater;
    }

    // best time to buy and sell stocks 
    public static int sellStocks(int arr[]){
        int bp = Integer.MAX_VALUE;
        int mp = 0;

        for(int i =0;i<arr.length;i++){
            if(bp < arr[i]){
                mp = Math.max(mp , arr[i] - bp);
            }
            else{
                bp = arr[i];
            }
        }
        return mp;
    } 
    public static void main(String[] args) {
        // int arr[] = {2, 4, 6, 8, 10, 12, 14 ,16};
        // int arr[] = {1 , -2 , 6 , -1 , 3};
        // int height[] = {4,2,0,6,3,2,5};
        // int arr[] = {7,1,5,3,6,4};
        // System.out.println(linearSearch(arr, 12));
        // System.out.println(largest(arr));
        // System.out.println(binarySearch(arr, 12));
        // maxSubSum(arr);
        // System.out.println(kadanes(arr));
        // System.out.println(trappingRainwater(height));
        // System.out.println(sellStocks(arr));
        int arr[] = {8,6,-5,-10,-11,-15,-20,-20};
        System.out.println(binarySearch2(arr, 0, arr.length-1, -20));
    }
}
