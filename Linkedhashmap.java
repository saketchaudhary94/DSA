import java.util.*;

public class Linkedhashmap {
    public static void main(String[] args) {
        LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        lhm.put("India" , 78);
        lhm.put("US" , 60);
        lhm.put("Nepal" , 50);
        lhm.put("Pakistan" , 20);
        
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India" , 78);
        hm.put("US" , 60);
        hm.put("Nepal" , 50);
        hm.put("Pakistan" , 20);

        System.out.println(hm);
        System.out.println(lhm);

    }
}
