import java.util.*;



class DAA033A {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int aresta = stdin.nextInt();

        stdin.nextLine();
        String[][] conects = new String[aresta][3];
        int ss = 0;
        String[] lista = new String[n];
        Graph g = new Graph(n);
        for (int i = 0; i < aresta; i++) {
            String k = stdin.nextLine();
            String[] s = k.split(" ");

            if (s.length >= 3) {
                conects[i][0] = s[0];
                conects[i][1] = s[1];
                conects[i][2] = s[2];
            }
            if (contains(s[0], lista) == false) {
                lista[ss] = s[0];
                ss++;
            }
            if (contains(s[1], lista) == false) {
                lista[ss] = s[1];
                ss++;
            }
        }
        
    }

    public static void print2DMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean contains(String x, String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public static int index(String x, String[] list) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == x) {
                return i;
            }
        }
        return -1;
    }
}