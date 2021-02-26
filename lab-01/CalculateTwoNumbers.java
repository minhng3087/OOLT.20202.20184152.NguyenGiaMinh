import java.util.Scanner;
public class CalculateTwoNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input 1st integer: ");
        int number1 = in.nextInt();
        System.out.print("Input 2nd integer: ");
        int number2 = in.nextInt();
        System.out.printf("Sum: %d\n", number1 + number2);
        System.out.printf("Difference: %d\n", number1 - number2);
        System.out.printf("Product: %d\n", number1 * number2);
        if(number2 != 0) {
            float quotient = (float)number1 / number2;
            System.out.printf("Quotient: %f\n", quotient);
        }else {
            System.out.printf("Quotient: Error\n");
        }
        in.close();


    }
}