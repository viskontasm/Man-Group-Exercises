package problem1;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class MaxScorePair {

    public static Pair<String, String> getPair(List<String> words) {
        if (words == null || words.size() < 2) {
            return null;
        }
        int maxScore = -1;
        Pair<String, String> pair = null;
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i +1 ; j < words.size(); j++) {
                int currentScore = ScoreStrings.getScore(words.get(i), words.get(j));
                if (maxScore < currentScore) {
                    pair = ImmutablePair.of(words.get(i), words.get(j));
                    maxScore = currentScore;
                }
            }
        }
        return pair;
    }
}
