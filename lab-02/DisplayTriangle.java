
import java.util.Scanner;
public class DisplayTriangle {

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.println("n = ");
		int n = keyboard.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j=1;j <= (2*i-1);j++ ) {
				System.out.print("*");
			}
			 System.out.println();
		}
		
		
		keyboard.close();
		
		
	}
		
	
}

