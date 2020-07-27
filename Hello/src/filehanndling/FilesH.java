package filehanndling;

import java.io.*;
import java.util.Scanner;

public class FilesH {
    public static void main(String[] args) throws IOException {
        File f = new File("Myfiles/text");
        f.mkdirs();
        f=new File("Myfiles/text/story.txt");
        try(BufferedWriter br = new BufferedWriter(new FileWriter(f, true))) {
            br.write("hello how are you");
            br.newLine();
        } catch(IOException e) {
            System.out.println("error: "+e.getMessage());
        }

        BufferedReader br=null;
        try{
            br = new BufferedReader(new FileReader(f));
            String line;
            while((line=br.readLine()) != null) {
                System.out.println("buffered copy: "+line);
            }
        } catch(IOException e) {
            System.out.println("error: "+e.getMessage());
        } finally {
            br.close();
        }

        System.out.println("**********************");

        Scanner sc = new Scanner(new File("Myfiles/text/story.txt"));
        String line;
        while(sc.hasNext()) {
            line = sc.nextLine();
            System.out.println("sacnned copy: "+line);
        }
    }
}
