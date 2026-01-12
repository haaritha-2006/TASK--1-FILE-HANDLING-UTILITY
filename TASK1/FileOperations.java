import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt";

        try {
            System.out.println("ENTER TEXT TO WRITE INTO FILE:");
            String text = sc.nextLine();

            FileWriter fw = new FileWriter(fileName);
            fw.write(text);
            fw.close();
            System.out.println("WRITE OPERATION COMPLETED.");

            System.out.println("\nFILE CONTENT AFTER WRITE:");
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

            System.out.println("\nENTER TEXT TO APPEND (MODIFY FILE):");
            String modifyText = sc.nextLine();

            FileWriter fwAppend = new FileWriter(fileName, true);
            fwAppend.write("\n" + modifyText);
            fwAppend.close();
            System.out.println("MODIFY OPERATION COMPLETED.");

            System.out.println("\nFINAL FILE CONTENT:");
            FileReader fr2 = new FileReader(fileName);
            BufferedReader br2 = new BufferedReader(fr2);
            while ((line = br2.readLine()) != null) {
                System.out.println(line);
            }
            br2.close();

        } catch (IOException e) {
            System.out.println("ERROR OCCURRED: " + e.getMessage());
        }

        sc.close();
    }
}
