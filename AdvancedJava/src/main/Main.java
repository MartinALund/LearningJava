package main;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

import main.java.Olives.Olive;

public class Main {

    public static void main(String[] args) throws IOException {

        writeLog("files/log.txt", "Code compiled at: " + new Date().toString());

    }

    static private void writeLog(String path, String message){
        Path logPath = Paths.get(path);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(logPath, charset, StandardOpenOption.APPEND)){
            writer.append(message);
            writer.newLine();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    static private void display(Collection<Olive> col){
        System.out.println("List order: ");
        for (Olive olive : col) {
            System.out.println(olive.oliveName.toString());
        }
    }

    //Java 7 try with resources, håndterer automatisk close på readers
    static private void tryWithResources() throws IOException{
        URL path = Main.class.getResource("files/textfile.txt");

        try(FileReader fr = new FileReader(path.getFile());
        BufferedReader br = new BufferedReader(fr)){
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static private void usingFinally() throws IOException{
        URL path = Main.class.getResource("files/textfile.txt");

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path.getFile());
            br = new BufferedReader(fr);

            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch(NullPointerException ex){
            System.out.println(ex.getLocalizedMessage());
        }finally{
            if(fr != null) fr.close();
            if(br != null) br.close();
        }
    }
}
