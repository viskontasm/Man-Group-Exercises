package problem1;

import org.junit.jupiter.api.Test;
import problem1.ScoreStrings;

import static org.junit.jupiter.api.Assertions.*;

class ScoreStringsTest {

    @Test
    public void testScoreWhenFirstStringNull() {
        assertEquals(0, ScoreStrings.scoreStrings(null, "aaa"));
    }

    @Test
    public void testScoreWhenFirstStringEmpty() {
        assertEquals(0, ScoreStrings.scoreStrings("", "aaa"));
    }

    @Test
    public void testScoreWhenSecondStringNull() {
        assertEquals(0, ScoreStrings.scoreStrings("aaa", null));
    }

    @Test
    public void testScoreWhenSecondStringEmpty() {
        assertEquals(0, ScoreStrings.scoreStrings("aaa", null));
    }

    @Test
    public void testScoreWhenCharacterShared() {
        assertEquals(0, ScoreStrings.scoreStrings("aaa", "abc"));
    }

    @Test
    public void testScoreWhenCharacterNotShared() {
        assertEquals(12, ScoreStrings.scoreStrings("aaa", "bcde"));
    }
}
