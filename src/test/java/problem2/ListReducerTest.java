package problem2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListReducerTest {

    @Test
    public void testWhenListNull() {
        assertNull(ListReducer.getReducedListByIndices(null, new int[] {0}));
    }

    @Test
    public void testWhenListEmpty() {
        assertEquals(new ArrayList<>(), ListReducer.getReducedListByIndices(new ArrayList<>(), new int[] {0}));
    }

    @Test
    public void testWhenIndicesEmpty() {
        assertEquals(new ArrayList<>(), ListReducer.getReducedListByIndices(new ArrayList<>(), new int[] {}));
    }

    @Test
    public void testRemoveIndicesOutsideList() {
        List<String> result = ListReducer.getReducedListByIndices(new ArrayList<>() {{ add("a"); }}, new int[] {1});
        List<String> expectedResult = new ArrayList<>() {{ add("a"); }};
        assertEquals(expectedResult, result);
    }

    @Test
    public void testRemoveIndicesNegativeOutsideList() {
        List<String> result = ListReducer.getReducedListByIndices(new ArrayList<>() {{ add("a"); }}, new int[] {-1});
        List<String> expectedResult = new ArrayList<>() {{ add("a"); }};
        assertEquals(expectedResult, result);
    }

    @Test
    public void testRemoveIndicesInList() {
        List<String> result = ListReducer.getReducedListByIndices(new ArrayList<>() {{ add("a"); add("b");
            add("c"); add("d"); add("e"); }}, new int[] {0, 3});
        List<String> expectedResult = new ArrayList<>() {{ add("b"); add("c"); add("e"); }};
        assertEquals(expectedResult, result);
    }
}
