import romanNumerals.RomanNumerals;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String a  = scanner.next();
        Calculator calculator = new Calculator(a);

    }
}
