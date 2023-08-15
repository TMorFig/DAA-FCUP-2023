import java.util.*;

public class DAA037 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int c = stdin.nextInt();
        int[][] list = new int[c][2];
        for (int i = 0; i != c; i++) {
            int m = stdin.nextInt();
            int mm = stdin.nextInt();
            list[i][0] = m;
            list[i][1] = mm;
        }
        int xm = 999999;
        int ym = 999999;
        for (int i = 0; i != c; i++) {
            if (list[i][0] < xm) {
                xm = list[i][0];
                ym = list[i][1];
            }
        }
        System.out.println(algorithmPrim(xm, ym, list, c));
    }

    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static double algorithmPrim(int x1, int y1, int[][] list, int c) {
        if (c == 0) {
            return 0.0; // Base case: empty list
        }

        boolean[] visited = new boolean[c];
        double[] distances = new double[c];
        Arrays.fill(distances, Double.MAX_VALUE);

        distances[0] = 0;

        for (int i = 0; i < c - 1; i++) {
            int minIndex = findMinDistance(distances, visited);
            visited[minIndex] = true;

            for (int j = 0; j < c; j++) {
                if (!visited[j]) {
                    double distance = dist(list[minIndex][0], list[minIndex][1], list[j][0], list[j][1]);
                    if (distance < distances[j]) {
                        distances[j] = distance;
                    }
                }
            }
        }

        double sum = 0;
        for (int i = 0; i < c; i++) {
            sum += distances[i];
        }

        return sum;
    }

    static int findMinDistance(double[] distances, boolean[] visited) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < min) {
                min = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}