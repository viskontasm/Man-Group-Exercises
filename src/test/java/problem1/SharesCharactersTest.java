package problem1;

import org.junit.jupiter.api.Test;
import problem1.SharesCharacters;

import static org.junit.jupiter.api.Assertions.*;

class SharesCharactersTest {

    @Test
    public void testWhenFirstStringNull() {
        assertFalse(SharesCharacters.sharesCharacters(null, "aaa"));
    }

    @Test
    public void testWhenFirstStringEmpty() {
        assertFalse(SharesCharacters.sharesCharacters("", "aaa"));
    }

    @Test
    public void testWhenSecondStringNull() {
        assertFalse(SharesCharacters.sharesCharacters("aaa", null));
    }

    @Test
    public void testWhenSecondStringEmpty() {
        assertFalse(SharesCharacters.sharesCharacters("aaa", null));
    }

    @Test
    public void testWhenSharesCharacter() {
        assertTrue(SharesCharacters.sharesCharacters("aaa", "abc"));
    }

    @Test
    public void testWhenNotSharedCharacter() {
        assertFalse(SharesCharacters.sharesCharacters("aaa", "bbc"));
    }
}
