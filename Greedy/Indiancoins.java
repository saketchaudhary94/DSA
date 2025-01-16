package Greedy;
import java.util.Arrays;

public class Indiancoins {
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;

        int count = 0;
        Arrays.sort(coins);

        for(int i = coins.length-1;i >=0;i--){
            if(amount >= coins[i]){
                while(amount >= coins[i]){
                    count++;
                    amount -= coins[i];
                }
            }
        }
        System.out.println(count);
    }
}
