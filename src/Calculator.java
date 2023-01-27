import romanNumerals.RomanNumerals;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Calculator {

    private String a, b;
    private int numA, numB, resultArabic;
    private String expression;
    private String action;
    private final Properties prop;
    private final Scanner scanner;
    boolean isRoman;


    Calculator() throws IOException {
        this.prop = new Properties();
        this.prop.load(Main.class.getClassLoader().getResourceAsStream("calc.properties"));
        System.out.println(this.prop.getProperty("welcome"));
        this.scanner = new Scanner(System.in);
    }

    public void calculate() throws CalcException {
        System.out.println(this.prop.getProperty("start_calculation"));
        this.expression = scanner.nextLine();
        defineOperation();
        splitExpression();
        parseNumbers();
        getResult();
    }

    public void defineOperation() throws CalcException {
        if (this.expression.contains("+")) //
            this.action = "\\+";
        else if (this.expression.contains("-"))
            this.action = "\\-";
        else if (this.expression.contains("*"))
            this.action = "\\*";
        else if (this.expression.contains("/"))
            this.action = "\\/";
        else {
            throw new CalcException(this.prop.getProperty("incorrect_action"));
        }
    }

    public void splitExpression() {
            String[] arr = this.expression.split(this.action);
            this.a = arr[0].trim();
            this.b = arr[1].trim();
    }

    public void parseNumbers() throws CalcException {
        try {
            this.numA = Integer.parseInt(this.a);
            this.numB = Integer.parseInt(this.b);
            isRoman = false;
        } catch (NumberFormatException e1) {
            try {
//                this.numA = RomanNumerals.valueOf(this.a).getArabicEquivalent();
//                this.numB = RomanNumerals.valueOf(this.b).getArabicEquivalent();
                isRoman = true;
                if((numA <= numB & this.action.contains("-")))
                    throw new CalcException(this.prop.getProperty("roman_incorrect"));
            } catch (IllegalArgumentException e2) {
                throw new CalcException(this.prop.getProperty("incorrect_input"));
            }
        }
    }

    public void getResult() throws CalcException {
        if((numA > 10 || numA < 1) || (numB > 10 || numB < 1)) {
            throw new CalcException(this.prop.getProperty("incorrect_input"));
        }
        if (this.expression.contains("+"))
            resultArabic = this.numA + this.numB;
        else if (this.expression.contains("-"))
            resultArabic = this.numA - this.numB;
        else if (this.expression.contains("*"))
            resultArabic = this.numA * this.numB;
        else if (this.expression.contains("/"))
           resultArabic = (int) ((double)this.numA / this.numB);

        if (isRoman && resultArabic >= 1 && resultArabic <= 10) {
            System.out.println("Результат: " + RomanNumerals.values()[resultArabic - 1]);
        } else if (!isRoman)
            System.out.println("Результат: " + resultArabic);
        else throw new CalcException(this.prop.getProperty("roman_incorrect"));
    }
}
