package problem1;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class SharesCharacters {

    public static boolean isCharacterShared(String one, String two) {
        if (isEmpty(one) || isEmpty(two)) {
            return false;
        }
        return one.chars().anyMatch(c -> checkIfCharIntExists(two, c)) ||
                two.chars().anyMatch(c -> checkIfCharIntExists(one, c));
    }

    private static boolean checkIfCharIntExists(String str, int intChar) {
        return str.chars().anyMatch(c -> intChar == c);
    }
}
