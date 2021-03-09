import java.util.Scanner;
public class JavaTwoMatrices {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Nhập kích thước của ma trận: ");
	    int n = s.nextInt();
	    int a[][] = new int[n][n];
	    int b[][] = new int[n][n];
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
	            a[i][j] = s.nextInt();
	        }
	    }
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
	            b[i][j] = s.nextInt();
	        }
	    }
	    int c[][] = new int[n][n];
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            c[i][j] = a[i][j] + b[i][j];
	            System.out.print(c[i][j]+" ");
	        }
	        System.out.println();
	    }
		s.close();
	}
}
