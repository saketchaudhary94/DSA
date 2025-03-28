package Recursion;
import java.util.*;

public class Subsets {

    public static void subSets(int arr[] , int idx , ArrayList<Integer> curr , ArrayList<ArrayList<Integer>> res){
        if(idx == arr.length){ 
            res.add(new ArrayList<>(curr));
            return;
            
        }
        // include 
        curr.add(arr[idx]);
        subSets(arr , idx+1,curr , res);

        // exclude 
        curr.remove(curr.size()-1);
        subSets(arr, idx+1, curr, res);

    }
    
    public static void print(ArrayList<ArrayList<Integer>> list){
        for(ArrayList<Integer> subList : list){
            System.out.print(subList +",");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subSets(arr, 0, new ArrayList<>(), res);
        print(res);
    }
}
