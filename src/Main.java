import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static boolean checkBalance (String expression) {
        //Create the stack
        Stack<Character> stack = new Stack<>();

        //Create for loop
        for(int i = 0; i < expression.length(); i++){
                char character = expression.charAt(i);

                //Push or Empty the stack
            if(character == '(' || character == '{' || character == '[' ) {
                stack.push(character);
            }else if (character == ')' || character == '}' || character == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char onTop = stack.pop();

                //Verify stack
                if ((character == ')' && onTop != '(') || (character == '}' && onTop != '{')
                        || (character == ']' && onTop != '[')) {
                    return false;                }
            }
        }

        return stack.isEmpty();


    }


    public static void main(String[] args) {
        //Ask the user for input
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the parentheses expression: ");
        String input = scan.nextLine();


        //Run the checkBalance method to verify user input
        if(checkBalance(input)){
            System.out.println("Balanced");
        }else {
            System.out.println("Not Balanced");

            //System.err.println("Not Balanced")
        }
        System.exit(0);
    }
}