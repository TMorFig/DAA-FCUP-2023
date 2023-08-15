import java.util.Scanner;
import java.util.Stack;

public class DAA029 {
    static int N;
    static String[] P;
    static boolean[] visited;
    static boolean[][] adj;
    static boolean[] exists;
    static Stack<Integer> answer;

    public static void adj() {
        for (int i = 0; i < N - 1; i++) {
            int j = i + 1;
            int size1 = P[i].length();
            int size2 = P[j].length();
            for (int a = 0; a < size1 && a < size2; a++) {
                if (P[i].charAt(a) != P[j].charAt(a)) {
                    adj[P[i].charAt(a) - 'A'][P[j].charAt(a) - 'A'] = true;
                    exists[P[i].charAt(a) - 'A'] = true;
                    exists[P[j].charAt(a) - 'A'] = true;
                    break;
                }
            }
        }
    }

    public static void dfs(int v) {
        visited[v] = true;
        for (int w = 0; w <30; w++) {
            if (!visited[w] && adj[v][w]) {
                dfs(w);
            }
        }
        answer.push(v);
    }

    public static void main(String[] Args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        P = new String[N];
        visited = new boolean[30];
        adj = new boolean[30][30];
        exists = new boolean[30];
        answer = new Stack<>();
        for (int i = 0; i < N; i++) {
            P[i] = in.next();
        }
        adj();
        for (int i = 0; i <= 26; i++) {
            if (exists[i] && !visited[i]) {
                dfs(i);
            }
        }
        while (!answer.isEmpty()) {
            int element = answer.pop();
            char character = (char) (element + 'A');
            System.out.print(character);
        }
        System.out.println();
    }
}