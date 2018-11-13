import Olives.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        writeLog();

        Olive lig = new Ligurio();
        Olive kal = new Kalamata();
        Olive pic = new Picholine();

        //region Hashset
        //Hashset ignorer duplicate objects, derfor er der stadig kun 3 i sidste sout da den er tilføjet før.

        HashSet<Olive> set = new HashSet<>();
        set.add(lig);
        set.add(kal);
        System.out.println("There are " + set.size() + " olives in the set.");
        set.add(pic);
        System.out.println("There are " + set.size() + " olives in the set.");
        set.add(lig);
        System.out.println("There are " + set.size() + " olives in the set.");
        set.remove(lig);
        System.out.println("There are " + set.size() + " olives in the set.");
        //endregion
        //region Treeset
        //Treeset sorterer listen løbende, derfor langsommere --> Class Olive implementerer comparable hvor man definerer hvad der skal sorteres på

        TreeSet<Olive> treeSet = new TreeSet<>();
        try{
            treeSet.add(pic);
            System.out.println(treeSet);
            treeSet.add(kal);
            System.out.println(treeSet);
            treeSet.add(lig);
            System.out.println(treeSet);
        }catch (Exception ex){
            System.out.println(ex);
        }
        //endregion
        //region LinkedList
        // Umiddelbart er concensus online at man bare skal bruge ArrayList istedet pga performance.
        //Why LinkedList sucks:
        //1. It uses lots of small memory objects, and therefore impacts performance across the process.
        //2. Lots of small objects are bad for cache-locality.
        //3. Any indexed operation requires a traversal, i.e. has O(n) performance. This is not obvious in the source code, leading to algorithms O(n) slower than if ArrayList was used.
        //4. Getting good performance is tricky.
        //5. Even when big-O performance is the same as ArrayList, it is probably going to be significantly slower anyway.
        //6. It's jarring to see LinkedList in source because it is probably the wrong choice.
        LinkedList<Olive> list = new LinkedList<>();
        list.add(new Picholine());
        list.add(new Kalamata());
        list.add(1, new Golden());
        list.addFirst(new Ligurio());
        display(list);
        // Poll returnerer reference til objektet og fjerner fra listen
        Olive o1 = list.pollFirst();
        System.out.println("Peek: " +o1.oliveName.toString());
        display(list);

        //endregion

    }

    static private void writeLog(){
        Path logPath = Paths.get("files/log.txt");
        Charset charset = Charset.forName("US-ASCII");
        String codeLog = "Code compiled at: " + new Date().toString();

        try (BufferedWriter writer = Files.newBufferedWriter(logPath, charset, StandardOpenOption.APPEND)){
            writer.append(codeLog);
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
