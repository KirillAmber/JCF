import java.util.Scanner;
import java.util.Stack;

public class Stack_task2 {
    public static void main(String[] args) {
        Stack<Character> stack_of_numbers_reverse = new Stack<>();
        Scanner in = new Scanner(System.in);
        String number = in.next();
        for(int i = 0; i < number.length(); i++)
        stack_of_numbers_reverse.add(number.charAt(i));
        while(!stack_of_numbers_reverse.empty())
        System.out.println(stack_of_numbers_reverse.pop());



    }
}
