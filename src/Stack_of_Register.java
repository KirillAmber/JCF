import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Stack_of_Register {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\ООП\\стих.txt"));
        String line = "";
        StringTokenizer tokenizer;
        while(((line = in.readLine()) !=null)) {
            tokenizer= new StringTokenizer(line, "\n");
            while(tokenizer.hasMoreTokens())
            list.add(tokenizer.nextToken());
        }
        list.sort(Comparator.comparing(String::length));
        for(String element : list)
            System.out.println(element);
    }
}
