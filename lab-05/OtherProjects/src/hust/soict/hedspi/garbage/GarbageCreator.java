package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {

    public static void main(String[] args) {
        try {
            File x = new File("file/1.txt");
            long start = System.currentTimeMillis();
            Scanner sc = new Scanner(x);
            String content = "";
            while(sc.hasNextLine()) {
                content += sc.nextLine() + "\n";
            }
//	  	      System.out.println(content);
            System.out.printf("Thoi gian xu ly: %d", System.currentTimeMillis() - start);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}