import java.util.Scanner;
public class QuadraticEquationTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ax^2+bx+c=0\n");
        System.out.print("Input four number a, b, c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double delta = b * b - 4.0 * a * c;

        if(delta == 0.0) {
            double x = -b/ (2.0 * a);
            System.out.println("x = " + x);
        }else if(delta > 0.0){
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }else {
            System.out.println("no solution");
        }

        
        in.close();
    }
}