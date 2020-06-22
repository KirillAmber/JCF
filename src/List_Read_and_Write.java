import java.io.*;
import java.util.*;

public class List_Read_and_Write {
    public static void main(String[] args) throws IOException {
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader in = new BufferedReader(new FileReader("c://ООП//pushkin.txt"));
        String line = "";
        while ((line = in.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            while (tokenizer.hasMoreTokens()) {
                list.add(tokenizer.nextToken());


            }
        }
            System.out.println(list);
            BufferedWriter out = new BufferedWriter(new FileWriter("c://ООП//pushkin.txt", true));
           // FileWriter out = new FileWriter("c://ООП//pushkin.txt", true);
            out.newLine();
            //out.write("\n");
            while (!list.isEmpty()) {
                out.write(list.pollLast() + " ");
                out.flush();
            }
        }
    }


