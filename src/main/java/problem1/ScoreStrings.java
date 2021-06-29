package problem1;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ScoreStrings {

    public static int scoreStrings(String one, String two) {
        if (SharesCharacters.sharesCharacters(one, two)) {
            return 0;
        }
        return getStringLength(one) * getStringLength(two);
    }

    private static int getStringLength(String str) {
        if (isEmpty(str)) {
            return 0;
        }
        return str.length();
    }
}
