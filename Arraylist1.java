import java.util.ArrayList;

public class Arraylist1 {

    public static int findMax(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i =0; i<list.size()-1;i++){
            if(max <  list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    public static void swapNum(ArrayList<Integer> list){
        int idx1 = 1, idx2 =3;
        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
        System.out.println(list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1,10);
        
        list.remove(1);
        list.set(1, 10);
        // System.out.println(list);
        // System.out.println(list.get(1));
        // System.out.println(list.contains(2));
        // size of a Arraylist 
        // System.out.println(list.size());
    
        System.out.println(findMax(list));
        System.out.println(list);
        swapNum(list);

    }
}
