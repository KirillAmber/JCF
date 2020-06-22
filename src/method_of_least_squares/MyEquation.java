package method_of_least_squares;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyEquation implements Gauss<Double, MyEquation> {
    private List<Double> equation = new ArrayList<Double>();

    public List<Double> getEquation(){
        return equation;
    }
   /* public void generate(int size){
        if (size < 2) size = 2;
        this.equation.clear();
        for (int i = 0; i < size; i++){
            Random random = new Random();
            this.equation.add((double) (random.nextInt()%10) + 1);
        }
    }*/
    public void generate(double x, double y, double b, int size){
        if (size < 2) size = 2;
        this.equation.clear();
        this.equation.add(x);
        this.equation.add(y);
        this.equation.add(b);
    }

    @Override
    public void addEquation(MyEquation item) {
        ListIterator<Double> i = equation.listIterator();
        ListIterator<Double> j = item.getEquation().listIterator();
        for(; i.hasNext() && j.hasNext();){
            Double a = i.next();
            Double b = j.next();
            i.set(a + b);
        }
    }

    @Override
    public void mul(Double coefficient) {
        for(ListIterator<Double> i = equation.listIterator(); i.hasNext();){
            Double next = i.next();
            i.set(next * coefficient);
        }
    }

    @Override
    public Double findCoefficient(Double a, Double b) {
        if (a == 0.0) return 1.0;
        return -b/a;
    }

    @Override
    public Double at(int index) {
        return equation.get(index);
    }

    @Override
    public int size() {
        return equation.size();
    }
}
