import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    // Method 1: Reverse String Method
    public static boolean reverseMethod(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return text.equals(reversed);

    }

    // Method 2: Stack Method
    public static boolean stackMethod(String text) {

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String word = "racecar";

        // Reverse Method Timing
        long start1 = System.nanoTime();
        boolean result1 = reverseMethod(word);
        long end1 = System.nanoTime();

        // Stack Method Timing
        long start2 = System.nanoTime();
        boolean result2 = stackMethod(word);
        long end2 = System.nanoTime();

        System.out.println("Reverse Method Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println();

        System.out.println("Stack Method Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");
    }

}