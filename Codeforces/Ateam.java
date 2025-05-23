package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.imageio.IOException;

public class Ateam {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int petya = Integer.parseInt(st.nextToken());
            int vasya = Integer.parseInt(st.nextToken());
            int tonya = Integer.parseInt(st.nextToken());
            
            int sum = petya + vasya + tonya;
            if (sum >= 2) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
