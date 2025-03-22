package FileNScanner.Application;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program  {
    public static void main(String[] args){
        String[] list = new String[]{"Good mornig", "Good Afternoon", "Good night"};

        String path = "c:\\temp\\out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (String line : list){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException err){
            System.out.println("Error: "+ err.getMessage());
        }
    }
}
