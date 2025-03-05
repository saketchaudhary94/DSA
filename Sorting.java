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

    // to print an array
    public static void print(int arr[]){
        for(int i =0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int arr[] = {5,4,1,2,3};
        int arr[] = {1,4,1,3,2,4,3,7};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        countingSort(arr);
        print(arr);
    }
}
