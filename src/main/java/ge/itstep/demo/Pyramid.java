package ge.itstep.demo;

public class Pyramid {
    public static void main(String[] args) {
        int height = 10;

        for (int i = 1; i <= height; i++) {
            // Print spaces for left alignment
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            // Print '*' characters for the pyramid
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Move to the next line
            System.out.println();
        }
    }
}