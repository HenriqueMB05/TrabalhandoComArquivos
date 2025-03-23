package Exercise.Application;

import Exercise.entities.Product;

import java.io.*;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter a file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr+ "\\out").mkdir();

        String targetFile = sourceFolderStr +"\\out\\sumary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){

            String itemCsv = br.readLine();
            while (itemCsv!=null){

                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))){
                for(Product item: list){
                    bw.write(item.getName()+","+String.format("%.2f", item.total()));
                    bw.newLine();
                }
            } catch (IOException err){
                System.out.println("Error writing file: "+err.getMessage());
            }
        } catch (IOException err){
            System.out.println("Error reading file: " +err.getMessage());
        }

    }
}
