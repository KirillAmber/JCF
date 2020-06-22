import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Union_and_Intersect_Sets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            set1.add(random.nextInt(10));
        for (int i = 0; i < 10; i++)
            set2.add(random.nextInt(10));
        System.out.println(set1);
        System.out.println(set2);

        System.out.println(intersects(set1, set2));
        System.out.println(union(set1, set2));

    }

    public static Set<Integer> intersects(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> set_of_intersects = new HashSet<>();
        if (s1.size() > s2.size()) {
            for (int element : s2)
                if (s1.contains(element))
                    set_of_intersects.add(element);
        }
        if(s1.size() < s2.size()){
            for (int element : s1)
                if (s2.contains(element))
                    set_of_intersects.add(element);
        }
        if(s1.size() == s2.size()){
            for (int element : s2)
                if (s1.contains(element))
                    set_of_intersects.add(element);
        }
              return  set_of_intersects;
    }
    public static Set<Integer> union(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> set_of_union = new HashSet<>();
        set_of_union.addAll(s1);
        set_of_union.addAll(s2);
        return  set_of_union;
    }
}
