import java.util.*;

public class Arraylist3 {

    //solved by using two pointer approach :
    public static boolean pairSum1(ArrayList<Integer>list , int target){
        int lp =0;
        int rp = list.size()-1;
        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            if(list.get(lp) + list.get(rp) < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int target =5;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1; i<=6;i++){
            list.add(i);
        }
        System.out.println(pairSum1(list, target));
    }
}
