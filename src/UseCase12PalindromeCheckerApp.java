import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String text);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return text.equals(reversed);
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Application Class
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "level";

        // Choose strategy dynamically
        PalindromeStrategy strategy;

        // Example: using Stack strategy
        strategy = new StackStrategy();

        boolean result = strategy.checkPalindrome(word);

        if (result) {
            System.out.println("Using Stack Strategy: \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Using Stack Strategy: \"" + word + "\" is NOT a Palindrome.");
        }

        // Switch to Deque Strategy
        strategy = new DequeStrategy();

        result = strategy.checkPalindrome(word);

        if (result) {
            System.out.println("Using Deque Strategy: \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Using Deque Strategy: \"" + word + "\" is NOT a Palindrome.");
        }
    }
}