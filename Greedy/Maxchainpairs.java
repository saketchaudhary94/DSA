package Greedy;
import java.util.*;

public class Maxchainpairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24} , {39,60} , {5,28} , {27,40} , {50 , 90}};

        Arrays.sort(pairs , (a,b)-> Integer.compare(a[1] , b[1]));
        int maxChain = 1;
        int lastEnd = pairs[0][1];

        for(int i =1;i<pairs.length;i++){
            if(pairs[i][0] > lastEnd){
                maxChain++;
                lastEnd = pairs[i][1];
            }
        }
        System.out.println(maxChain);
    }
}
