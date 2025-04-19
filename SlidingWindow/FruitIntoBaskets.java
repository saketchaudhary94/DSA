package SlidingWindow;
import java.util.HashMap;

public class FruitIntoBaskets {

    public static int fruitInBaskets(int arr[]){
        int maxLen = 0;
        int i =0 , j = 0;
        HashMap<Integer , Integer> map = new HashMap<>();

        while(j < arr.length){
            map.put(arr[j] , map.getOrDefault(arr[j] , 0)+1);

            while(map.size() > 2){
                map.put(arr[i] , map.get(arr[i])-1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }

            maxLen = Math.max(maxLen , j -i+1);
            j++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(fruitInBaskets(arr));
    }
}
