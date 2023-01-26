package romanNumerals;

public enum RomanNumerals {
    I("I", 1),
    II("II", 2),
    III("III", 3),
    IV("IV", 4),
    V("V", 5),
    VI("VI", 6),
    VII("VII", 7),
    VIII("VIII", 8),
    IX("IX", 9),
    X("X", 10);

    private final String RomanNumeral;
    private final int ArabicEquivalent;

    RomanNumerals(String RomanNumeral, int ArabicEquivalent) {
        this.ArabicEquivalent = ArabicEquivalent;
        this.RomanNumeral = RomanNumeral;
    }

    public int getArabicEquivalent() {
        return ArabicEquivalent;
    }

    public String getRomanNumeral() {
        return RomanNumeral;
    }
}
