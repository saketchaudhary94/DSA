package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ForestQueries {
    
    static long prefix[][];
    static int n;
    
    public static long helper(int row1, int col1, int row2, int col2){
        return prefix[row2+1][col2+1] - prefix[row2+1][col1] - prefix[row1][col2+1] + prefix[row1][col1];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        char matrix[][] = new char[n][n];
        
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                matrix[i][j] = line.charAt(j);
            }
        }
        
        prefix = new long[n+1][n+1];
        
        for(int i = 1; i < prefix.length; i++){
            for(int j = 1; j < prefix[0].length; j++){
                prefix[i][j] = (matrix[i-1][j-1] == '*' ? 1 : 0)
                             + prefix[i][j-1]
                             + prefix[i-1][j]
                             - prefix[i-1][j-1];
            }
        }

        // ✅ Use StringBuilder for faster output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken()); // y1
            int col1 = Integer.parseInt(st.nextToken()); // x1  
            int row2 = Integer.parseInt(st.nextToken()); // y2
            int col2 = Integer.parseInt(st.nextToken()); // x2
            
            sb.append(helper(row1-1, col1-1, row2-1, col2-1)).append('\n');
        }
        
        System.out.print(sb); // Print all results at once
    }
}
