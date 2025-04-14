package SlidingWindow;
import java.util.HashMap;

public class LongestSubstringWihtoutRepeatingChar {

    public static int longestSubstring(String str){
        int i =0 , j =0 , maxLen =0;
        HashMap<Character ,Integer> map = new HashMap<>();

        while(j < str.length()){
            char ch = str.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch) >= i){
                    i = map.get(ch) +1;
                }
            }
            map.put(ch , j);
            maxLen = Math.max(maxLen , j-i+1);
            j++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(longestSubstring(str));
    }
}
