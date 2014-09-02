package stack;
//----------------------------------------------------------------------
// ReverseStrings.java         by Dale/Joyce/Weems                Chapter 3
//
// Sample use of stack. Outputs strings in reverse order of entry.
//----------------------------------------------------------------------

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BoundedStackInterface<String> stack;
        stack = new ArrayStack<String>(4);

        String line;

        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter a line of text > ");
            line = input.nextLine();
            try {
                stack.push(line);
            }
            catch (StackOverflowException ex) {
                System.out.println(ex);
            }
        }

        System.out.println("\nReversed String is:\n");
        while (!stack.isEmpty()) {
            System.out.println(stack.top());
            stack.pop();
        }
    }
}
