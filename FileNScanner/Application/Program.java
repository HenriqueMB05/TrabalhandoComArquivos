package FileNScanner.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program  {
    public static void main(String[] args){
        FileReader fr = null;
        BufferedReader br =null;

        String path = "c:\\temp\\in.txt";

        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();

            while(line !=null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException err){
            System.out.println("Error: "+ err.getMessage());
        } finally {
            try{
                if(br !=null){
                    br.close();
                } if(fr !=null){
                    fr.close();
                }
            } catch (IOException err){
                err.printStackTrace();
            }
        }

    }
}
