import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Original_Frequency_words {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\ООП\\стих.txt"));
        Object ob = new HashSet();
        System.out.print((ob instanceof Set) + ", ");
        System.out.print(ob instanceof SortedSet);
        //original_words(in);
        word_frequency(in);
    }

    public static void original_words(BufferedReader in) throws IOException {
        Set<String> set = new HashSet<>();
        String line = "";
        String word = "";
        while ((line = in.readLine())!=null){
            StringTokenizer tokenizer = new StringTokenizer(line, " ,!?.-:;()'");
            while(tokenizer.hasMoreTokens()){
                word = tokenizer.nextToken();
                if(!(set.contains(word.toLowerCase()) || set.contains(word.toUpperCase())))
                    set.add(word);
            }
        }
        for(String element : set)
            System.out.println(element);
    }
    public static void word_frequency(BufferedReader in) throws  IOException{
        Map<String, Integer> map = new HashMap<>();
        String line = "";
        String word = "";
        while ((line = in.readLine())!=null) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ,!?.-:;()'");
            while (tokenizer.hasMoreTokens()){
                word = tokenizer.nextToken();
                if(map.containsKey(word)){
                    map.put(word, map.get(word) + 1);
                }
                else{
                    map.put(word, 1);
                }

            }
        }
        System.out.println("Frequency of words:");
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach(System.out::println);
        /*for(Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());*/
    }


}
