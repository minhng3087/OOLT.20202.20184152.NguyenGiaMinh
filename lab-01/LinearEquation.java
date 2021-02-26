import java.util.Scanner;
public class LinearEquation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input 1st integer: ");
        int number1 = in.nextInt();
        System.out.print("Input 2nd integer: ");
        int number2 = in.nextInt();
        if(number1 != 0) {
            float result = (float) -number2 / number1;
            System.out.printf("Quotient: %f\n", result);
        }else {
            System.out.printf("Error\n");
        }
        in.close();

    }
}