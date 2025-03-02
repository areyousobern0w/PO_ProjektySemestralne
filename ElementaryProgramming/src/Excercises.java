import java.util.Scanner;

public class Excercises {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the temperature in Celsius: ");
        double celsius = input.nextDouble();

        double fahrenheit = (((9.0 / 5.0) * celsius) + 32);
        System.out.println(celsius + " celsius is " + fahrenheit + " fahrenheit.");
    }
}
