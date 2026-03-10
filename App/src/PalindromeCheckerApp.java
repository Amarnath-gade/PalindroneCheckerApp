import java.util.*;

public class PalindromeCheckerApp {

    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean result1 = stackPalindrome(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = dequePalindrome(input);
        long end2 = System.nanoTime();

        System.out.println("Stack Method Result: " + result1);
        System.out.println("Stack Method Time: " + (end1 - start1) + " ns");

        System.out.println("Deque Method Result: " + result2);
        System.out.println("Deque Method Time: " + (end2 - start2) + " ns");

        sc.close();
    }
}