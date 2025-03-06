import java.util.*;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(1);

        // System.out.println(set);
        // set.remove(2);
        // if(set.contains(2)){
        //     System.out.println(true);
        // }
        // System.out.println(set);
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());

        // iteration on set 
        // Iterator it = set.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        // iterate using smart loops 
        for(Integer key : set){
            System.out.println(key);
        }
    }
}
