package FileNScanner.Application;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Program  {
    public static void main(String[] args){
        File file = new File("C:\\temp\\in.txt");
        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException err){
            System.out.println("Error: "+err.getMessage());
        } finally {
            if(sc != null) {
                sc.close();
            }
        }


    }
}
