public class Sorting {

    // bubble sort function worst case time complexity O(n^2)
    public static void bubbleSort(int arr[]){
        for(int i =0;i<arr.length;i++){
            int swaps = 0;
            for(int j =0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0){
                break;
            }
        }
    }

    // selection sort function time complexity O(n^2)
    public static void selectionSort(int arr[]){
        for(int i =0;i<arr.length-1;i++){
            int min  = i;
            for(int j =i+1;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // insertion sort function time complexity O(n^2)
    public static void insertionSort(int arr[]){
        for(int i =1;i < arr.length;i++){
            int curr = arr[i];
            int prev = i-1;

            while(prev >=0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    // function to counting sort 
    public static void countingSort(int arr[]){
        // find the largest to make count array
        if(arr.length == 0){
            return;
        }
        int largest = arr[0];
        for(int i=0;i<arr.length;i++){
            largest = Math.max(largest , arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i =0;i<arr.length;i++){
            count[arr[i]]++;
        }

        int j =0;
        for(int i =0;i<count.length;i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    // merge sort
    public static void conquer(int arr[], int si , int mid , int ei){
        int merged[] = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x =0;

        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                merged[x++] = arr[idx1++];
            }
            else{
                merged[x++] = arr[idx2++];
            }
        }
        while(idx1 <= mid){
            merged[x++] = arr[idx1++];
        }
        while(idx2 <= ei){
            merged[x++] = arr[idx2++];
        }
        for(int i=0,j=si;i<merged.length;i++,j++){
            arr[j] = merged[i];

        }

    }

    public static void divide(int arr[] , int si , int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si) /2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }

    // quick sort 
    public static int partition(int arr[] , int s , int e){
        int pvt = arr[s];
        int cnt = 0;
        
        for(int i =s+1;i <= e;i++){
            if(arr[i] <= pvt){
                cnt++;
            }
        }
        int ci = s + cnt;
        int temp = arr[s];
        arr[s] = arr[ci];
        arr[ci] = temp;

        int i = s , j = e;
        while(i < ci && j > ci){
            while(arr[i] <= pvt) i++;
            while(arr[j] > pvt) j--;
            if(i < ci && j > ci){
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }
        }
        return ci;
    }

    public static void quickSort(int arr[] , int s , int e){
        if(s >= e){
            return;
        }
        int pvt = partition(arr , s , e);
        quickSort(arr, s, pvt -1);
        quickSort(arr, pvt+1, e);
    }

    // to print an array
    public static void print(int arr[]){
        for(int i =0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int arr[] = {5,4,1,2,3};
        // int arr[] = {1,4,1,3,2,4,3,7};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // countingSort(arr);
        // print(arr);

        // for merge sort 
        // int arr[] = {6,3,9,5,2,8};
        // int n = arr.length;
        // divide(arr , 0 , n-1);

        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();


        // for quick sort 
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        print(arr);
    }
}
