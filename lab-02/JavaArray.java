import java.util.*;
public class JavaArray
{
    public static void main(String[] args) 
    {
        int b[] = new int[1000];
        Random rand = new Random();
        for(int i=0; i<1000; i++) {
            b[i]=rand.nextInt(100);   
        }
        int n, sum = 0;
        float average;
        Scanner s = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        n = s.nextInt();
        int a[] = new int[n];
        System.out.println("Nhập phần tử của mảng: ");
        for(int i = 0; i < n ; i++)
        {
            s.nextLine();
            if( s.hasNextInt()) a[i] = s.nextInt();
            else if(s.hasNextLine()) {
                a[i] = b[i];
            }
                  
            sum = sum + a[i];
        }
        System.out.println("Sum:"+sum);
        average = (float)sum / n;
        System.out.println("Average:"+average);
        System.out.println("Mảng trước sắp xếp: ");
        System.out.printf("%s", Arrays.toString(a));
        System.out.println();
        System.out.println("Mảng sau khi sắp xếp: ");
        Arrays.sort(a);
        System.out.printf("%s", Arrays.toString(a));
        s.close();
    }
}