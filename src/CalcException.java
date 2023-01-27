public class CalcException extends Exception{
    public CalcException(String message) {
        System.out.println(message);
        System.exit(1);
    }
}
