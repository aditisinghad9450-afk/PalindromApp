public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "A man a plan a canal Panama";

        // Normalize the string
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        // Compare characters
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("The string \"" + text + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a Palindrome.");
        }
    }
}