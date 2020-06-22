import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Mul_polynomial {
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
        Sum_polynomial.printPolynomial(polynom1);
        System.out.println();
        System.out.println("The second polynomial:");
        Sum_polynomial.printPolynomial(polynom2);
        System.out.println();
        System.out.println("Multiplication of polynomials:");
        Sum_polynomial.printPolynomial(mul_polynom(polynom1, polynom2));
    }
    public static HashMap<Integer, Integer> mul_polynom(HashMap<Integer, Integer> polynom1,
                                                        HashMap<Integer, Integer> polynom2){
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        if(polynom1.size() > polynom2.size()){
            for(int i = 0; i< polynom1.size(); i++) {
                for(int j = 0; j<polynom2.size(); j++) {
                    if(result.containsKey(i+j)) // similar terms
                        result.put(i+j, result.get(i+j) + polynom1.get(i)*polynom2.get(j));
                    else
                        result.put(i+j, polynom1.get(i)*polynom2.get(j));
                }
            }
        }
        if(polynom1.size() < polynom2.size()){
            for(int i = 0; i< polynom2.size(); i++) {
                for(int j = 0; j<polynom1.size(); j++) {
                    if(result.containsKey(i+j)) //similar terms
                        result.put(i+j, result.get(i+j) + polynom2.get(i)*polynom1.get(j));
                    else
                        result.put(i+j, polynom2.get(i)*polynom1.get(j));
                }
            }
        }
        if(polynom1.size() == polynom2.size()){
            for(int i = 0; i< polynom1.size(); i++) {
                for(int j = 0; j<polynom2.size(); j++) {
                    if(result.containsKey(i+j)) // similar terms
                        result.put(i+j, result.get(i+j) + polynom1.get(i)*polynom2.get(j));
                    else
                        result.put(i+j, polynom1.get(i)*polynom2.get(j));
                }
            }
        }




        return result;
    }
}
