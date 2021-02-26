import java.util.Scanner;
public class LinearSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ax+by=e\ncx+dy=f\n");
        System.out.print("Input four number a, b, c, d, e, f: ");
        int a= in.nextInt();
        int b= in.nextInt();
        int c= in.nextInt();
        int d= in.nextInt();
        int e= in.nextInt();
        int f= in.nextInt();
        int det = (a * d - b * c); 
         int det1 = (d * e - b * f);
        int det2 = (a * f - c * e);
        if(det!=0) {
            float x = (float) det1 / det;
            float y = (float) det2 / det;
            System.out.print("x=" + x + " y=" + y);
        }
        else if(det==0) {
            if(det1 == det2 && det== det1) {
                System.out.println("infinitely many solutions");
            }
            System.out.println("Error");

        }
        in.close();
    }
}