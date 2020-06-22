import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class F_positive_L_negative {
    private static final int N = 20;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Random random = new Random();
        for(int i = 0; i<N ; i++){
            list.add(random.nextInt(100)-50);
        }
        System.out.println(list);


        /*boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > list.get(i - 1)) {
                    Collections.swap(list, i, i - 1);
                    isSorted = false;
                }
            }
        }*/
        list.sort(Comparator.comparingInt(Integer::intValue).reversed());
        System.out.println("After sorting:");
        System.out.println(list);
    }
}
