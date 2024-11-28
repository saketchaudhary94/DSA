import java.util.*;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<String , Integer> tm = new TreeMap<>();
        tm.put("India" , 78);
        tm.put("US" , 60);
        tm.put("Nepal" , 50);
        tm.put("Pakistan" , 20);
        
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India" , 78);
        hm.put("US" , 60);
        hm.put("Nepal" , 50);
        hm.put("Pakistan" , 20);

        System.out.println(hm);
        System.out.println(tm);
    }
}
