import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int x, y;
        for (int i = 0; i < tokens.length; i++) {
        	switch(tokens[i]) {
        		case "+" :
        			y = Integer.parseInt(stack.pop());
        			x = Integer.parseInt(stack.pop());
        			stack.push(Integer.toString(x + y));
        			break;
        		case "-":
        			y = Integer.parseInt(stack.pop());
        			x = Integer.parseInt(stack.pop());
        			stack.push(Integer.toString(x - y));
        			break;
    			case "*":
    				y = Integer.parseInt(stack.pop());
    				x = Integer.parseInt(stack.pop());
    				stack.push(Integer.toString(x * y));
    				break;
				case "/":
					y = Integer.parseInt(stack.pop());
					x = Integer.parseInt(stack.pop());
					stack.push(Integer.toString(x / y));
					break;
				default:
					stack.push(tokens[i]);
        	}
        }
        return Integer.parseInt(stack.peek());
    }
}