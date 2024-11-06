import java.util.*;

public class Arraylist2 {

    // container with most water problem :
    public static int mostWater(ArrayList<Integer> list){
        int lp = 0;
        int rp = list.size()-1;
        int maxWater = 0;
        while(lp < rp){
            int height = Math.min(list.get(lp) , list.get(rp));
            int width = rp - lp;
            int currWater = height * width;
            maxWater =  Math.max(maxWater , currWater);

            if(list.get(lp) < list.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        mainList.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        // System.out.println(mainList);

        // printing by iteration method :
        for(int i =0;i<mainList.size();i++){
            ArrayList<Integer> newList = mainList.get(i);
            for(int j=0;j < newList.size();j++){
                System.out.print(newList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mostWater(list));
    }
}
