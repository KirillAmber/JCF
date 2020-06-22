import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Swap_Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        Random random = new Random();
        for(int i = 0; i<10; i++)
            stack1.add(random.nextInt(10));
        for(int i = 0; i<10; i++)
            stack2.add(random.nextInt(10));
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println("Let's swap stacks");
        int size_of_stack1 = stack1.size();
        int size_of_stack2 = stack2.size();
        for(int i = 0; i < size_of_stack1; i++)
            tempStack.add(stack1.pop());
        for(int i = 0; i < size_of_stack2; i++)
            tempStack.add((stack2.pop()));
        for(int i = 0; i < size_of_stack2; i++)
            stack1.add(tempStack.pop());
        for(int i = 0; i < size_of_stack1; i++)
            stack2.add(tempStack.pop());

        System.out.println(stack1);
        System.out.println(stack2);

    }
}
