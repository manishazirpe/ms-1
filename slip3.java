import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Store the original number for comparison
        int originalNumber = number;
        int reversedNumber = 0;

        // Reverse the digits of the number
        while (number > 0) {
            int digit = number % 10; // Extract the last digit
            reversedNumber = reversedNumber * 10 + digit; // Build the reversed number
            number /= 10; // Remove the last digit
        }

        // Check if the original number and reversed number are the same
        if (originalNumber == reversedNumber) {
            System.out.println(originalNumber + " is a palindrome.");
        } else {
            System.out.println(originalNumber + " is not a palindrome.");
        }

        // Close the scanner
        scanner.close();
    }
}

Q.2) 
    interface Operation {
    // Constant for PI
    double PI = 3.142;

    // Methods to calculate area and volume
    double area();
    double volume();
}

// Circle class implementing Operation interface
class Circle implements Operation {
    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Calculate area of the circle
    @Override
    public double area() {
        return PI * radius * radius;
    }

    // Circle does not have a volume, return 0
    @Override
    public double volume() {
        return 0;
    }
}

// Cylinder class implementing Operation interface
class Cylinder implements Operation {
    double radius;
    double height;

    // Constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Calculate area of the cylinder (2πr² + 2πrh)
    @Override
    public double area() {
        return 2 * PI * radius * (radius + height);
    }

    // Calculate volume of the cylinder (πr²h)
    @Override
    public double volume() {
        return PI * radius * radius * height;
    }
}

// Main class to test the functionality
public class InterfaceExample {
    public static void main(String[] args) {
        // Create a Circle object
        Circle circle = new Circle(5);
        System.out.println("Circle:");
        System.out.println("Area: " + circle.area());
        System.out.println("Volume: " + circle.volume());

        // Create a Cylinder object
        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println("\nCylinder:");
        System.out.println("Area: " + cylinder.area());
        System.out.println("Volume: " + cylinder.volume());
    }
}


