package problem1;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import problem1.MaxScorePair;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaxScorePairTest {

    @Test
    public void testPairWhenListNull() {
        assertNull(MaxScorePair.getPair(null));
    }

    @Test
    public void testPairWhenListIsEmpty() {
        assertNull(MaxScorePair.getPair(new ArrayList<>()));
    }

    @Test
    public void testPairWhenListSizeBellowTwo() {
        assertNull(MaxScorePair.getPair(new ArrayList<>() {{ add("1111"); }}));
    }

    @Test
    public void testPairWhenAllItemsShared() {
        Pair<String, String> result = MaxScorePair.getPair(new ArrayList<>() {{ add("a"); add("ab");
            add("acc"); add("addd"); add("abcdefg"); }});
        Pair<String, String> expected = ImmutablePair.of("a", "ab" );
        assertEquals(expected, result);
    }

    @Test
    public void testPairWhenCharacterShared() {
        Pair<String, String> result = MaxScorePair.getPair(new ArrayList<>() {{ add("a"); add("bb");
            add("ccc"); add("bddd"); add("abcdefg"); }});
        Pair<String, String> expected = ImmutablePair.of("ccc", "bddd" );
        assertEquals(expected, result);
    }

    @Test
    public void testScoreWhenCharacterNotShared() {
        Pair<String, String> result = MaxScorePair.getPair(new ArrayList<>() {{ add("1111"); add("zzzz");
            add("aaaaaa"); add("ddd"); }});
        Pair<String, String> expected = ImmutablePair.of("1111", "aaaaaa" );
        assertEquals(expected, result);
    }
}
