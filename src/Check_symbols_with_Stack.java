import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Check_symbols_with_Stack {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\ООП\\symbols_for_stack.txt"));
        char symbol = ' ';
        while((int)(symbol = (char) in.read())!= 65535) {
            if(symbol == '(' || symbol == '[' || symbol == '{')
                stack.add(symbol);
            if(symbol == ')')
                if(stack.peek() == '(')
                    stack.pop();
                else {
                    System.out.println("Statement is not correct");
                    System.exit(-1);
                }
            if(symbol == ']')
                if(stack.peek() == '[')
                    stack.pop();
                else {
                    System.out.println("Statement is not correct");
                    System.exit(-1);
                }
            if(symbol == '}')
                if(stack.peek() == '{')
                    stack.pop();
                else {
                    System.out.println("Statement is not correct");
                    System.exit(-1);
                }

        }
        System.out.println("All is correct");
    }
}
