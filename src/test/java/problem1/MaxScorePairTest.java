package problem1;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaxScorePairTest {

    @Test
    public void testPairWhenListNull() {
        assertNull(MaxScorePair.maxWordPair(null));
    }

    @Test
    public void testPairWhenListIsEmpty() {
        assertNull(MaxScorePair.maxWordPair(new ArrayList<>()));
    }

    @Test
    public void testPairWhenListSizeBellowTwo() {
        assertNull(MaxScorePair.maxWordPair(new ArrayList<>() {{ add("1111"); }}));
    }

    @Test
    public void testPairWhenAllItemsShared() {
        Pair<String, String> result = MaxScorePair.maxWordPair(new ArrayList<>() {{ add("a"); add("ab");
            add("acc"); add("addd"); add("abcdefg"); }});
        Pair<String, String> expected = ImmutablePair.of("a", "ab" );
        assertEquals(expected, result);
    }

    @Test
    public void testPairWhenCharacterShared() {
        Pair<String, String> result = MaxScorePair.maxWordPair(new ArrayList<>() {{ add("a"); add("bb");
            add("ccc"); add("bddd"); add("abcdefg"); }});
        Pair<String, String> expected = ImmutablePair.of("ccc", "bddd" );
        assertEquals(expected, result);
    }

    @Test
    public void testScoreWhenCharacterNotShared() {
        Pair<String, String> result = MaxScorePair.maxWordPair(new ArrayList<>() {{ add("1111"); add("zzzz");
            add("aaaaaa"); add("ddd"); }});
        Pair<String, String> expected = ImmutablePair.of("1111", "aaaaaa" );
        assertEquals(expected, result);
    }
}
