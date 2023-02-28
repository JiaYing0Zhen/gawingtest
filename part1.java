/**
* The main function of this program is 
* a four-operation calculator for 2 positive integer numbers.
* @author  Jia Ying Zhen
* @version 1.0
* @since   2022-09-12 
*/
import java.util.Scanner;
import java.util.Stack;
public class part1{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String expression = new String();
        System.out.println("Enter the expression form like: \"postive-number operation postive-number\"");
        
        // Enter the expression and store the expression in char array
        expression = keyboard.nextLine();
        char[] token = expression.toCharArray();
        
        // Create the stack for the positive integer number
        Stack<Integer> number = new Stack<Integer>();

        // Create the stack for the operation
        Stack<Character> operation = new Stack<Character>();

        // Take the value from the char array into the numbers' stack, 
        // and take the operation character in the same way.
        for(int i = 0; i < token.length; i++){
            // Skip the space
            if(token[i] == ' '){
                continue;
            }
            // The value part:
            if(token[i] >= '0' && token[i] <= '9'){
                StringBuffer numberString = new StringBuffer();
                // if the value has multi-digit
                while(i < token.length && token[i] >= '0' && token[i] <= '9')
                numberString.append(token[i++]);
                number.push(Integer.parseInt(numberString.toString()));
                // decreasing the value of i by 1 to correct the offset
                i--;
                
            }
            // The operation part:
            else if(token[i] == '+' || token[i] == '-' || token[i] == '*' || token[i] == '/'){
                operation.push(token[i]);
            } 
        }

        // The final part which to calculate and display the two positive integer number
        while(!operation.empty()){
            number.push(operate(operation.pop(),number.pop(),number.pop()));
        }
        System.out.println(expression + " = " + number.pop());
        keyboard.close();
    }

    private static int operate(char pop1, int pop2, int pop3){
       if(pop1 == '+'){
        return pop2 + pop3;
       }
       if(pop1 == '-'){
        return pop2 - pop3;
       }
       if(pop1 == '*'){
        return pop2 * pop3;
       }
       if(pop1 == '/'){
            if(pop3 != 0){
                return pop2 / pop3;
            }
            else{
                throw new ArithmeticException("The divisor cannot be zero!");
            }
       }
       return 0;
    }
}
