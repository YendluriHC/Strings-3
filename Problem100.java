//Time: O(n)
//Space: O(n)
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the current character is a digit, build the number
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }

            // If the current character is an operator or end of the string
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                // Update for the next number and reset currentNumber
                operation = currentChar;
                currentNumber = 0;
            }
        }

        // Sum all the elements in the stack to get the result
        int result = 0;
        for (int num : stack) {
            result += num;
        }

        return result;  
    }
}
