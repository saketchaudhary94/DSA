package Greedy;
import java.util.*;

public class Chocolaproblem {
    public static void main(String[] args) {
        int n =4 ,m =6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};
        
        Arrays.sort(costVer , Collections.reverseOrder());
        Arrays.sort(costHor , Collections.reverseOrder());

        int h =0 , v =0;
        int vp =1 , hp =1;
        int cost =0;

        while(v < costVer.length && h < costHor.length){
            if(costVer[v] <= costHor[h]){
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            else{
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(v < costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        while(h < costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        System.out.println("min cost of pieces is :"+ cost);
    }
}
