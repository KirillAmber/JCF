package method_of_least_squares;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Method_of_least_squares {
    private static final int DEFAULT_EQUATIONS_NUMBER = 2;
    private static final int DEFAULT_VARIABLES_NUMBER = 2;
    public static void main(String[] args) {
        List<Double> amperage = new ArrayList<>();
        List<Double> voltage = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<10; i++) {
            amperage.add((double)(random.nextInt(10) + random.nextDouble()));
            voltage.add((double)(random.nextInt(20) + random.nextDouble()));
        }
        System.out.println("Voltage:");
        System.out.println(voltage);
        System.out.println("Amperage");
        System.out.println(voltage);
        least_squares(amperage, voltage);




    }
    public static void least_squares(List<Double> amperage, List<Double> voltage){
        System.out.println("To find resistance apply method of least_squares");
        double sum_x = 0, sum_x2 = 0, sum_y = 0, sum_x_y = 0;
        for(int i = 0; i<amperage.size(); i++){
            sum_x += amperage.get(i);
            sum_x2 += Math.pow(amperage.get(i), 2);
            sum_y += voltage.get(i);
            sum_x_y += amperage.get(i)*voltage.get(i);
        }
        LinearSystem<Double, MyEquation> list = generateSystem(sum_x2, sum_x, sum_x_y,
                                                                sum_x, amperage.size(), sum_y);
        printSystem(list);
        System.out.println("To solve the system of equations, we use the method_of_least_squares.Gauss method\n");
        int i, j;
        Algorithm<Double, MyEquation> alg = new Algorithm<Double, MyEquation>(list);
        try{
            alg.calculate();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Double [] x = new Double[DEFAULT_EQUATIONS_NUMBER];
        for(i = list.size() - 1; i >= 0; i--) {
            Double sum = 0.0;
            for(j = list.size() - 1; j > i; j--) {
                sum += list.itemAt(i, j) * x[j];
            }
            x[i] = (list.itemAt(i, list.size()) - sum) / list.itemAt(i, j);
        }
        printSystem(list);
        printVector(x);

        System.out.println("Resistance = " + x[0]);

    }
    public static LinearSystem<Double, MyEquation> generateSystem(double x0, double y0, double b0,
                                                                    double x1, double y1, double b1){
        LinearSystem<Double, MyEquation> list = new LinearSystem<Double, MyEquation>();
        int i;

            MyEquation eq = new MyEquation();
            eq.generate(x0, y0, b0, DEFAULT_VARIABLES_NUMBER + 1);
            list.push(eq);
            eq = new MyEquation();
            eq.generate(x1, y1, b1, DEFAULT_VARIABLES_NUMBER + 1);
            list.push(eq);
        return list;
    }
    public static void printSystem(LinearSystem<Double, MyEquation> system){
        System.out.println();
        for (int i = 0; i < system.size(); i++){
            MyEquation temp = system.get(i);
            String s = "";
            for (int j = 0; j < temp.size(); j++){
                s += String.format("%f; %s", system.itemAt(i, j), "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }
    public static void printVector(Double [] x){
        String s = "";
        for (int i = 0; i < x.length; i++){
            s += String.format("x%d = %f; ", i, x[i]);
        }System.out.println(s);
    }
}
