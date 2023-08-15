import java.util.*;


public class DAA006 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();


        double[][] numbers = new double[n][6];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 6; j++) {
                numbers[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(intersecao(numbers[i][0], numbers[i][1], numbers[i][2], numbers[i][3], numbers[i][4], numbers[i][5]));
        }


        input.close();
    }
    public static double intersecao(double qx,double qy,double l,double c1,double c2, double  r){
        double x2 = qx + l;
        double y2 = qy + l;
        double area = 0;

        if((qx - c1) * (qx - c1) + (qy - c2) * (qy - c2) < r*r &&(qx - c1) * (qx - c1) + (y2 - c2) * (y2 - c2) < r*r &&(x2 - c1) * (x2 - c1) + (qy - c2) * (qy - c2) < r*r &&(x2 - c1) * (x2 - c1) + (y2 - c2) * (y2 - c2) < r*r)
            return l * l; 

        if((c1 + r) < (qx + l) &&(c1 - r) > qx &&(c2 + r) < (qy + l) &&(c2 - r) > qy)
            return  3.1415926535897 * r * r; 

        if((qx - c1) * (qx - c1) + (qy - c2) * (qy - c2) > r*r && (qx - c1) * (qx - c1) + (y2 - c2) * (y2 - c2) > r*r &&(x2 - c1) * (x2 - c1) + (qy - c2) * (qy - c2) > r*r &&(x2 - c1) * (x2 - c1) + (y2 - c2) * (y2 - c2) > r*r &&
            !(c1 > qx && c1 < x2) &&
            !(c2 > qy && c2 < y2)
            )
            return 0; 

        if(l>=0.001){
            l /= 2;
            area += intersecao(qx, qy + l, l, c1, c2, r);
            area += intersecao(qx + l, qy + l, l, c1, c2, r);
            area += intersecao(qx, qy, l, c1, c2, r);
            area += intersecao(qx + l, qy, l, c1, c2, r);
        }

        return area;
    }

}