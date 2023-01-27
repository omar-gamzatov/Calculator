package romanNumerals;

public class RomanNumerals {

    private Map<Integer, String> map =
    I("1", "I"),
    II("2", "II"),
    III("3", "III"),
    IV("4", "IV"),
    V("5", "V"),
    VI("6", "VI"),
    VII("7", "VII"),
    VIII("8", "VIII"),
    IX("9", "IX"),
    X("10", "X"),
    L("50", "L"),
    C("100", "C");
    private final String RomanNumeral;
    private final String ArabicEquivalent;

    RomanNumerals(String ArabicEquivalent, String RomanNumeral) {
        this.ArabicEquivalent = ArabicEquivalent;
        this.RomanNumeral = RomanNumeral;
    }

    public String getArabicEquivalent() {
        return ArabicEquivalent;
    }

    public String getRomanNumeral() {
        return RomanNumeral+1;
    }
}
