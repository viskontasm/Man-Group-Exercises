import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordLengthProductTest {

    WordLengthProduct wordLengthProduct = new WordLengthProduct();

    @Test
    public void testWhenFirstStringNull() {
        boolean result = wordLengthProduct.sharesCharacters(null, "aaa");
        assertFalse(result);
    }

    @Test
    public void testWhenFirstStringEmpty() {
        boolean result = wordLengthProduct.sharesCharacters("", "aaa");
        assertFalse(result);
    }

    @Test
    public void testWhenSecondtringNull() {
        boolean result = wordLengthProduct.sharesCharacters("aaa", null);
        assertFalse(result);
    }

    @Test
    public void testWhenSecondStringEmpty() {
        boolean result = wordLengthProduct.sharesCharacters("aaa", null);
        assertFalse(result);
    }

    @Test
    public void testWhenSharesCharacter() {
        boolean result = wordLengthProduct.sharesCharacters("aaa", "abc");
        assertTrue(result);
    }

    @Test
    public void testWhenNotSharedCharacter() {
        boolean result = wordLengthProduct.sharesCharacters("aaa", "bbc");
        assertFalse(result);
    }
}
