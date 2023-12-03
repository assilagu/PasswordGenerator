package password;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*_=+-/";

    public static String generate(int length, boolean useLower, boolean useUpper, boolean useDigits, boolean useSymbols) {
        String charSet = "";
        if (useLower) charSet += LOWER;
        if (useUpper) charSet += UPPER;
        if (useDigits) charSet += DIGITS;
        if (useSymbols) charSet += SYMBOLS;
        if (charSet.isEmpty()) throw new IllegalArgumentException("Au moins un type de caractère doit être sélectionné");

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charSet.length());
            password.append(charSet.charAt(index));
        }

        return password.toString();
    }
}
