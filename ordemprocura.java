import java.sql.Connection;
import java.util.*;
public class ordemprocura {
    static int n;             
    static boolean adj[][];   
    static boolean visited[];
    static LinkedList<Integer> grafa;  
    static  LinkedList<Integer> connects;
    static int depth;
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        connects = new LinkedList<Integer>();
        grafa = new LinkedList<Integer>();
        n = stdin.nextInt();
        depth = 0;
        adj     = new boolean[n+1][n+1];
        visited = new boolean[n+1];	
        int edges = stdin.nextInt();	
        for (int i=0; i<edges; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            adj[a][b]  = true;
        }
        System.out.println("bruh");
        visited[0] = true;
        dfsvisited2(1);
        System.out.println(grafa);  
    }
    static void dfsvisited(int start){
        visited[start] = true;
        grafa.add(start);
        for(int i = 0; i<=n;i++){
            if(adj[start][i] == true && visited[i]==false){
                dfsvisited(i);
            }
        }
    }
    static void bfs(int start){
        int depth2 =0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(start);
        

    }
}
