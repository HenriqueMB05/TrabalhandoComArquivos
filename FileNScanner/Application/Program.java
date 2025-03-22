package FileNScanner.Application;

import java.io.File;
import java.util.Scanner;

public class Program  {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        for(File folder : folders){
            System.out.println(folder);
        }

        boolean success = new File(strPath+ "\\subdir").mkdir();
        System.out.println("Directory created successfully: "+ success);



        sc.close();
    }
}
