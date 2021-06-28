import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ScoreStrings {

    public static int getScore(String one, String two) {
        if (SharesCharacters.isCharacterShared(one, two)) {
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
