import romanNumerals.RomanNumerals;

import java.io.IOException;
import java.util.Properties;

public class Calculator {

    private String a, b;
    private int numA, numB;
    private final String expression;
    private String action;
    private final Properties prop;
    public boolean flag;



    Calculator(String expression) throws IOException {
        this.prop = new Properties();
        this.prop.load(Main.class.getClassLoader().getResourceAsStream("calc.properties"));
        System.out.println(this.prop.getProperty("welcome"));
        this.expression = expression;
        actionLoop();
    }

    public void actionLoop() {
        findAction();
        splitExpression();
        parseNumbers();
        getResult();
    }

    public void findAction() {
        if (this.expression.contains("+"))
            this.action = "\\+";
        else if (this.expression.contains("-"))
            this.action = "\\-";
        else if (this.expression.contains("*"))
            this.action = "\\*";
        else if (this.expression.contains("/"))
            this.action = "\\/";
        else {
            System.out.println(this.prop.getProperty("incorrect_action"));
            System.exit(1);
        }
    }

    public void splitExpression() {
            String[] arr = this.expression.split(this.action);
            this.a = arr[0].trim();
            this.b = arr[1].trim();
    }

    public void parseNumbers() {
        try {
            this.numA = Integer.parseInt(this.a);
            this.numB = Integer.parseInt(this.b);
        } catch (NumberFormatException e1) {
            try {
                this.numA = RomanNumerals.valueOf(this.a).getArabicEquivalent();
                this.numB = RomanNumerals.valueOf(this.b).getArabicEquivalent();
            } catch (IllegalArgumentException e2) {
                System.out.println(this.prop.getProperty("incorrect_input"));
                System.exit(1);
            }
        }
    }

    public void getResult() {
        if (this.expression.contains("+"))
            System.out.println(this.numA + this.numB);
        else if (this.expression.contains("-"))
            System.out.println(this.numA - this.numB);
        else if (this.expression.contains("*"))
            System.out.println(this.numA * this.numB);
        else if (this.expression.contains("/"))
            System.out.println(this.numA / this.numB);
    }

}
