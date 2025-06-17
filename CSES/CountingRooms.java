package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingRooms {
    static char graph[][];
    static boolean vis[][];
    static int n;
    static int m;

    public static void dfs(int i , int j){
        if(i <0 || i>= n || j < 0 || j>= m || graph[i][j] == '#'){
            return;
        }

        graph[i][j] = '#';
        dfs(i-1 , j);
        dfs(i+1 , j);
        dfs(i , j-1);
        dfs(i , j+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];

        
        for(int i =0;i < n;i++){
            String line = br.readLine();
            for(int j =0;j < m;j++){
                graph[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for(int i =0;i < n;i++){
            for(int j =0;j < m;j++){
                if(graph[i][j] == '.'){
                    dfs(i , j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}