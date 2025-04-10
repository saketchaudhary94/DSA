package CSES;

import java.util.Scanner;

public class Repetitions {

    public static void repetitiions(String str){
        int max = 0;
        int count = 0;
        int i =0 , j =0;

        while(j < str.length()){
            if(str.charAt(i) == str.charAt(j)){
                count++;
            }
            else{
                max = Math.max(max , count);
                i = j;
                count = 1;
            }
            j++;
        }
        max = Math.max(max ,count);
        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        repetitiions(str);
    }
}
