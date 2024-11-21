Q1)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmstrongNumber {
    public static void main(String[] args) throws IOException {
        // Create a BufferedReader object to read input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = Integer.parseInt(reader.readLine());

        // Store the original number for comparison
        int originalNumber = number;
        int result = 0;
        int numDigits = String.valueOf(number).length();

        // Calculate the Armstrong sum
        while (number > 0) {
            int digit = number % 10;
            result += Math.pow(digit, numDigits);
            number /= 10;
        }

        
        if (result == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }
}


Q2) Define an Interface Shape with abstract method area().
 Write a java program to calculate an area of Circle and Sphere.(use final keyword)
 import java.util.Scanner;

interface Shape{
    void area();
}
class Circle implements Shape{
    final float PI=3.14f;
    float areacircle,radius;
    Scanner s=new Scanner(System.in);
    void accept(){
        System.out.print("Enter the Radius of circle : ");
        radius=s.nextFloat();
    }
    public void area(){
    areacircle=PI*radius*radius;
    }
    public void show()
    {
    System.out.println("Area of circle is : "+areacircle);
    }
}

class Sphere implements Shape{
    final float PI=3.14f;
    float areasphere,radius;
    Scanner s=new Scanner(System.in);
    void accept(){
        System.out.print("Enter the Radius of sphere : ");
        radius=s.nextFloat();
    }
    public void area(){
        areasphere=4*PI*radius*radius;
    }
    public void show(){
        System.out.println("Area of Sphere is : "+areasphere);
    }
}
class InterfaceCircleSphere
{
    public static void main(String args[]){
        Circle s1=new Circle();
        s1.accept();
        s1.area();
        s1.show();
        Sphere s2=new Sphere();
        s2.accept();
        s2.area();
        s2.show();
    }
}



