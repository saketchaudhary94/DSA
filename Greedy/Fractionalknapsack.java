package Greedy;

import java.util.Arrays;

public class Fractionalknapsack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int wt[] = {10,20,30};
        int w = 50;

        double ratio[][] = new double[val.length][2];

        for(int i =0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/ (double)wt[i];
        }

        Arrays.sort(ratio , (a,b)-> Double.compare(b[1], a[1]));

        int capacity = w;
        int finalVal = 0;

        for(int i = val.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= wt[idx]){
                finalVal += val[idx];
                capacity -= wt[idx];
            }
            else{
                finalVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println(finalVal);
    }
}
