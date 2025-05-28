// Exercise 1: Hello World
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// Exercise 2: Simple Calculator
import java.util.Scanner;
public class SimpleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double x = sc.nextDouble();
        System.out.print("Enter second number: ");
        double y = sc.nextDouble();
        System.out.print("Choose operation (+ - * /): ");
        char op = sc.next().charAt(0);
        double res = 0;
        switch (op) {
            case '+': res = x + y; break;
            case '-': res = x - y; break;
            case '*': res = x * y; break;
            case '/': res = y != 0 ? x / y : Double.NaN; break;
            default: System.out.println("Invalid operator"); return;
        }
        System.out.println("Result: " + res);
    }
}

// Exercise 3: Even or Odd Checker
import java.util.Scanner;
public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        System.out.println(num % 2 == 0 ? "Even" : "Odd");
    }
}

// Exercise 4: Leap Year Checker
import java.util.Scanner;
public class YearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type a year: ");
        int inputYear = sc.nextInt();
        boolean isLeap = (inputYear % 4 == 0 && inputYear % 100 != 0) || (inputYear % 400 == 0);
        System.out.println(isLeap ? "Leap Year" : "Not a Leap Year");
    }
}

// Exercise 5: Multiplication Table
import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}

// Exercise 6: Data Type Demonstration
public class DataTypeOverview {
    public static void main(String[] args) {
        int age = 25;
        float pi = 3.14f;
        double gravity = 9.80665;
        char grade = 'B';
        boolean isJavaFun = true;

        System.out.println("int: " + age);
        System.out.println("float: " + pi);
        System.out.println("double: " + gravity);
        System.out.println("char: " + grade);
        System.out.println("boolean: " + isJavaFun);
    }
}

// Exercise 7: Type Casting
public class CastingDemo {
    public static void main(String[] args) {
        double temp = 98.6;
        int approxTemp = (int) temp;
        System.out.println("Double to int: " + approxTemp);

        int score = 42;
        double preciseScore = score;
        System.out.println("Int to double: " + preciseScore);
    }
}

// Exercise 8: Operator Precedence
public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Result: " + result);
    }
}

// Exercise 9: Grade Calculator
import java.util.Scanner;
public class GradeEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your score (0-100): ");
        int score = sc.nextInt();
        char grade = score >= 90 ? 'A' :
                     score >= 80 ? 'B' :
                     score >= 70 ? 'C' :
                     score >= 60 ? 'D' : 'F';
        System.out.println("Grade: " + grade);
    }
}

// Exercise 10: Number Guessing Game
import java.util.*;
public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        int secret = rnd.nextInt(100) + 1, attempt;

        do {
            System.out.print("Guess a number (1-100): ");
            attempt = input.nextInt();
            if (attempt < secret) System.out.println("Too low!");
            else if (attempt > secret) System.out.println("Too high!");
            else System.out.println("Correct guess!");
        } while (attempt != secret);
    }
}

// Exercise 11: Factorial Calculator
import java.util.Scanner;
public class FactorialFinder {
    public static int computeFactorial(int num) {
        return (num <= 1) ? 1 : num * computeFactorial(num - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int value = input.nextInt();
        System.out.println("Factorial is: " + computeFactorial(value));
    }
}

// Exercise 12: Method Overloading
public class OverloadAddition {
    static int sum(int x, int y) {
        return x + y;
    }

    static double sum(double x, double y) {
        return x + y;
    }

    static int sum(int x, int y, int z) {
        return x + y + z;
    }

    public static void main(String[] args) {
        System.out.println(sum(5, 7));
        System.out.println(sum(4.2, 3.8));
        System.out.println(sum(1, 2, 3));
    }
}

// Exercise 13: Recursive Fibonacci
import java.util.Scanner;
public class RecursiveFibo {
    static int getFibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return getFibo(n - 1) + getFibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the position of Fibonacci number: ");
        int pos = input.nextInt();
        System.out.println("Fibonacci number is: " + getFibo(pos));
    }
}

// Exercise 14: Array Sum and Average
import java.util.Scanner;
public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        double avg = (double) sum / n;
        System.out.println("Sum: " + sum + ", Average: " + avg);
    }
}

// Exercise 15: String Reversal
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);
        System.out.println("Reversed: " + sb.reverse());
    }
}

// Exercise 16: Palindrome Checker
import java.util.Scanner;
public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type a string to check: ");
        String text = input.nextLine().replaceAll("[\\W_]", "").toLowerCase();
        String reversedText = new StringBuilder(text).reverse().toString();
        System.out.println(text.equals(reversedText) ? "It's a Palindrome" : "Not a Palindrome");
    }
}

// Exercise 17: Class and Object Creation
class Vehicle {
    String brand, type;
    int manufactureYear;

    Vehicle(String brand, String type, int year) {
        this.brand = brand;
        this.type = type;
        this.manufactureYear = year;
    }

    void showInfo() {
        System.out.println("Brand: " + brand + ", Type: " + type + ", Year: " + manufactureYear);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Honda", "Civic", 2021);
        v1.showInfo();
    }
}

// Exercise 18: Inheritance Example
class Creature {
    void sound() {
        System.out.println("Generic sound");
    }
}

class Cat extends Creature {
    void sound() {
        System.out.println("Meow");
    }

    public static void main(String[] args) {
        Creature c = new Creature();
        c.sound();
        Cat cat = new Cat();
        cat.sound();
    }
}

// Exercise 19: Interface Implementation
interface Playable {
    void play();
}
class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming the guitar");
    }
}
class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano");
    }
    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}

// Exercise 20: Try-Catch Example
import java.util.Scanner;
public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }
}
