import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Sum_polynomial {
    public static void main(String[] args) {
        int degree1, degree2;
        HashMap<Integer, Integer> polynom1 = new HashMap<>();
        HashMap<Integer, Integer> polynom2 = new HashMap<>();
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter degree for 1st polynomial");
        degree1 = in.nextInt();
        System.out.println("Enter degree for 2st polynomial");
        degree2 = in.nextInt();

        for(int i = 0; i<degree1+1; i++) {
            polynom1.put(i, random.nextInt(100)-50);
        }
        for(int i = 0; i<degree2+1; i++){
            polynom2.put(i, random.nextInt(100)-50);
        }
        System.out.println("The first polynomial:");
        printPolynomial(polynom1);
        System.out.println();
        System.out.println("The second polynomial:");
        printPolynomial(polynom2);
        System.out.println();
        System.out.println("Sum of polynomials");
        printPolynomial(sum_polynom(polynom1, polynom2));








    }

    public static HashMap<Integer, Integer> sum_polynom(HashMap<Integer, Integer> polynom1,
                                                        HashMap<Integer, Integer> polynom2){

        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        if(polynom1.size() > polynom2.size()){
            for(int i = 0; i< polynom1.size(); i++) {
                if (polynom1.containsKey(i) && polynom2.containsKey(i))
                    result.put(i, polynom1.get(i) + polynom2.get(i));
                else if (polynom1.containsKey(i))
                    result.put(i, polynom1.get(i));
            }
        }
        if(polynom1.size() < polynom2.size()){
            for(int i = 0; i< polynom2.size(); i++) {
                if (polynom1.containsKey(i) && polynom2.containsKey(i))
                    result.put(i, polynom1.get(i) + polynom2.get(i));
                else if (polynom2.containsKey(i))
                    result.put(i, polynom2.get(i));
            }
        }
        if(polynom1.size() == polynom2.size()){
            for(int i = 0; i< polynom1.size(); i++) {
                if (polynom1.containsKey(i) && polynom2.containsKey(i))
                    result.put(i, polynom1.get(i) + polynom2.get(i));
                else if (polynom1.containsKey(i))
                    result.put(i, polynom1.get(i));
            }
        }



        return result;
    }
    public static void printPolynomial(HashMap<Integer, Integer> polynom){
        boolean first = true;
        for (Map.Entry<Integer, Integer> entry : polynom.entrySet()) { // Value = coef, Key = x^
            if(first) {
                System.out.print(entry.getValue() + "x^" + entry.getKey());
                first = false;
            }
            else if(!first && entry.getValue() >= 0){
                System.out.print("+" + entry.getValue() + "x^" + entry.getKey());
            }
            else if(!first && entry.getValue() < 0){
                System.out.print(entry.getValue() + "x^" + entry.getKey());
            }
        }
    }

}
