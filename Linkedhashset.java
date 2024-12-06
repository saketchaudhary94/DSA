import java.util.*;

public class Linkedhashset {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Agra");
        cities.add("BSR");
        System.out.println(cities);

        HashSet<String> set = new HashSet<>();
        set.add("Delhi");
        set.add("Mumbai");
        set.add("Agra");
        set.add("BSR");
        System.out.println(set);

    }
}
