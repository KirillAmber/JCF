import java.util.*;

public class PairwiseSummation {
    private static final int  N = 11;
    public static void main(String[] args) {
        TreeSet<Integer> row_of_numbers = new TreeSet<>();
        TreeSet<Integer> tempSet = new TreeSet<>();
        Random random = new Random();
        for(int i = 0; i < N; i++)
        row_of_numbers.add(random.nextInt(100));
        System.out.println(row_of_numbers);
        tempSet.addAll(row_of_numbers);
        while(tempSet.size() != 1){
            tempSet = sum_1(tempSet);
        }
        System.out.println(tempSet);


    }
    public static TreeSet<Integer>sum_1(TreeSet<Integer> set){
        TreeSet<Integer> phase_sum_1 = new TreeSet<>();
        int count_iterataion = 0;
        int element1 = 0;
         for(int element : set){
            if(set.size()%2 ==1 && element == set.last()) {
                phase_sum_1.add(element);
                break;
            }
            if(count_iterataion == 0) {
                element1 = element;
                count_iterataion += 1;
                continue;
            }
            if(count_iterataion == 1) {
                phase_sum_1.add(element + element1);
                count_iterataion = 0;
           }
        }

        System.out.println(phase_sum_1);
        return  phase_sum_1;
    }
}
