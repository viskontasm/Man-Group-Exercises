import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreStringsTest {

    @Test
    public void testScoreWhenFirstStringNull() {
        assertEquals(0, ScoreStrings.getScore(null, "aaa"));
    }

    @Test
    public void testScoreWhenFirstStringEmpty() {
        assertEquals(0, ScoreStrings.getScore("", "aaa"));
    }

    @Test
    public void testScoreWhenSecondStringNull() {
        assertEquals(0, ScoreStrings.getScore("aaa", null));
    }

    @Test
    public void testScoreWhenSecondStringEmpty() {
        assertEquals(0, ScoreStrings.getScore("aaa", null));
    }

    @Test
    public void testScoreWhenCharacterShared() {
        assertEquals(0, ScoreStrings.getScore("aaa", "abc"));
    }

    @Test
    public void testScoreWhenCharacterNotShared() {
        assertEquals(12, ScoreStrings.getScore("aaa", "bcde"));
    }
}
