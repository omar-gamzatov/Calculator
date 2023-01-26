import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String a  = scanner.next();
        calculator.calculate(a);
    }
}
