import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lisf_of_Folds_and_Elements {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\ООП\\");
        ArrayList<String> list = new ArrayList<>();
        if(file.isDirectory()) {
            if(file.listFiles() != null) {
                for (int i = 0; i < file.listFiles().length; i++) {
                    list.add(file.listFiles()[i].getName());
                    if(file.listFiles()[i].isDirectory()){
                        for (int j = 0; j < file.listFiles()[i].listFiles().length; j++) {
                            list.add(file.listFiles()[i].listFiles()[j].getName());
                        }
                    }
                }
            }
        }
    for(String element : list){
        System.out.println(element);
    }

    }
}
