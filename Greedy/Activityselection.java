package Greedy;

import java.util.Arrays;

public class Activityselection {

    // function if given that end is sorted
    public static int maxAct1(int start[] , int end[]){
        int maxAct = 1;
        int lastEnd = end[0];

        for(int i =1;i<end.length;i++){
            if(start[i] >= lastEnd){
                maxAct++;
                lastEnd = end[i];
            }
        }
        return maxAct;
    }

    // function if end is not sorted 
    public static int maxAct2(int start[] , int end[]){
        int act[][] = new int[start.length][3];

        for(int i =0;i<start.length;i++){
            act[i][0] = i;
            act[i][1] = start[i];
            act[i][2] = end[i];
        }

        Arrays.sort(act , (a,b)-> Integer.compare(a[2], b[2]));

        int maxAct = 1;
        int lastEnd = act[0][2];
        for(int i =1;i < start.length;i++){
            if(act[i][1] >= lastEnd){
                maxAct++;
                lastEnd = act[i][2];
            }
        }
        return maxAct;
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        System.out.println(maxAct1(start, end));
        System.out.println(maxAct2(start, end));
    }
}
