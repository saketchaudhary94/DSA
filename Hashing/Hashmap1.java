package Hashing;
import java.util.*;

public class Hashmap1 {
    public static void main(String[] args) {
        // create
        HashMap<String , Integer> hm = new HashMap<>();

        // Insert O(1)
        hm.put("India" , 100);
        hm.put("China" , 150);
        hm.put("Nepal" , 1);
        hm.put("US" , 50);
        hm.put("Indonesia" , 5);

        // // Get O(1)
        // System.out.println(hm.get("India"));

        // // containsKey O(1)
        // System.out.println(hm.containsKey("India")); // return true
        // System.out.println(hm.containsKey("Russia")); // return flase
        
        // // remove - O(1)
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        // // size 
        // System.out.println(hm.size());

        // // is empty 
        // System.out.println(hm.isEmpty());

        Set<String> keys = hm.keySet();

        for(String k : keys){
            System.out.println("key = "+ k + " " +"value = "+ hm.get(k));
        }
    }
}
