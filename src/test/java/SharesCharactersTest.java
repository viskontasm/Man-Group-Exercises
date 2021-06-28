import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharesCharactersTest {

    @Test
    public void testWhenFirstStringNull() {
        assertFalse(SharesCharacters.isCharacterShared(null, "aaa"));
    }

    @Test
    public void testWhenFirstStringEmpty() {
        assertFalse(SharesCharacters.isCharacterShared("", "aaa"));
    }

    @Test
    public void testWhenSecondStringNull() {
        assertFalse(SharesCharacters.isCharacterShared("aaa", null));
    }

    @Test
    public void testWhenSecondStringEmpty() {
        assertFalse(SharesCharacters.isCharacterShared("aaa", null));
    }

    @Test
    public void testWhenSharesCharacter() {
        assertTrue(SharesCharacters.isCharacterShared("aaa", "abc"));
    }

    @Test
    public void testWhenNotSharedCharacter() {
        assertFalse(SharesCharacters.isCharacterShared("aaa", "bbc"));
    }
}
