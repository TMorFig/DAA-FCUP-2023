import java.util.Scanner;

public class DAA027 {
    private static final int MAX = 51;
    private static final int NaoVisitado = 0;
    private static final int AZUL = 1;
    private static final int VERMELHO = 2;

    private static int nos, arestas, cor;
    private static boolean[][] adj = new boolean[MAX][MAX];
    private static int[] colored = new int[MAX];

    private static void reset(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                adj[i][j] = false;
            colored[i] = NaoVisitado;
        }
    }

    private static boolean paint(int x, int cor) {
        int novaCor = (cor == AZUL) ? VERMELHO : AZUL;
        if (colored[x] != NaoVisitado) {
            if (colored[x] != novaCor) return false;
            return true;
        }
        if (colored[x] == NaoVisitado) {
            colored[x] = novaCor;
            for (int i = 0; i < nos; i++) {
                if (adj[x][i])
                    if (!paint(i, novaCor)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
		String[] respos =new String[cases];
		int k=0;
        for (int a = 0; a < cases; a++) {
            int tmpX, tmpY;
            nos = scanner.nextInt();
            arestas = scanner.nextInt();

            for (int i = 0; i < arestas; i++) {
                tmpY = scanner.nextInt();
                tmpX = scanner.nextInt();
                tmpY--;
                tmpX--;
                adj[tmpY][tmpX] = true;
                adj[tmpX][tmpY] = true;
            }
			
            boolean answer = paint(0, AZUL);
			

            if (answer){
				respos[k] = "sim";
			}
            else{
				respos[k] = "nao";
			}
			k++;

            reset(nos);
        }
		for(int i = 0; i != cases; i++){
			System.out.println(respos[i]);
		}
    }
}