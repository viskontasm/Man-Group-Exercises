package problem2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListReducerTest {

    /* Problem 2, part 1*/
    @Test
    public void testWhenListNull() {
        assertNull(ListReducer.reducedListByIndices(null, new ArrayList<>() {{ add(0); }}));
    }

    @Test
    public void testWhenListEmpty() {
        assertEquals(new ArrayList<>(), ListReducer.reducedListByIndices(new ArrayList<>(), new ArrayList<>() {{ add(0); }}));
    }

    @Test
    public void testWhenIndicesNull() {
        assertEquals(new ArrayList<>() {{ add("a"); }}, ListReducer.reducedListByIndices(new ArrayList<>() {{ add("a"); }}, null));
    }

    @Test
    public void testWhenIndicesEmpty() {
        assertEquals(new ArrayList<>() {{ add("a"); }}, ListReducer.reducedListByIndices(new ArrayList<>() {{ add("a"); }}, new ArrayList<>()));
    }

    @Test
    public void testRemoveIndicesOutsideList() {
        List<Object> result = ListReducer.reducedListByIndices(new ArrayList<>() {{ add("a"); }}, new ArrayList<>() {{ add(1); }});
        List<String> expectedResult = new ArrayList<>() {{ add("a"); }};
        assertEquals(expectedResult, result);
    }

    @Test
    public void testRemoveIndicesNegativeOutsideList() {
        List<Object> result = ListReducer.reducedListByIndices(new ArrayList<>() {{ add("a"); }}, new ArrayList<>() {{ add(-1); }});
        List<String> expectedResult = new ArrayList<>() {{ add("a"); }};
        assertEquals(expectedResult, result);
    }

    @Test
    public void testRemoveIndicesInList() {
        List<Object> result = ListReducer.reducedListByIndices(new ArrayList<>() {{ add("a"); add("b");
            add("c"); add("d"); add("e"); }}, new ArrayList<>() {{ add(0); add(3); }});
        List<String> expectedResult = new ArrayList<>() {{ add("b"); add("c"); add("e"); }};
        assertEquals(expectedResult, result);
    }

    /* Problem 2, part 2*/
    @Test
    public void test2TupleRemoveIndicesWhenListNull() {
        List<Integer> innerIndices = new ArrayList<>() {{ add(0); }};
        List<List<Object>> result = ListReducer.reduced2TupleListByIndices(null, new ArrayList<>() {{ add(innerIndices); }});
        assertNull(result);
    }

    @Test
    public void test2TupleRemoveIndicesWhenListEmpty() {
        List<Integer> innerIndices = new ArrayList<>() {{ add(0); }};
        assertEquals(new ArrayList<>(),
                ListReducer.reduced2TupleListByIndices(new ArrayList<>(), new ArrayList<>() {{ add(innerIndices); }}));
    }

    @Test
    public void test2TuplesWhenIndicesEmpty() {
        List<Object> innerList = new ArrayList<>() {{ add("a"); add("b"); add("c"); add("d"); add("e"); }};
        List<List<Object>> outerList = new ArrayList<>() {{ add(innerList); }};
        List<List<Object>> expectedResult = new ArrayList<>() {{ add(innerList); }};
        assertEquals(expectedResult, ListReducer.reduced2TupleListByIndices(outerList, new ArrayList<>()));
    }

    @Test
    public void test2TupleRemoveIndicesInList() {
        List<Object> list1 = new ArrayList<>() {{ add("a"); add("b"); add("c"); add("d"); add("e"); }};
        List<Object> list2 = new ArrayList<>() {{ add("a"); add("b"); add("c"); }};
        List<List<Object>> fullList = new ArrayList<>() {{ add(list1); add(list2); }};

        List<Integer> indice1 = new ArrayList<>() {{ add(0); add(0); }};
        List<Integer> indice2 = new ArrayList<>() {{ add(0); add(3); }};
        List<Integer> indice3 = new ArrayList<>() {{ add(1); add(1); }};
        List<List<Integer>> fullIndices = new ArrayList<>() {{ add(indice1); add(indice2); add(indice3); }};

        List<Object> resultList1 = new ArrayList<>() {{ add("b"); add("c"); add("e"); }};
        List<Object> resultList2 = new ArrayList<>() {{ add("a");  add("c"); }};
        List<List<Object>> expectedResult = new ArrayList<>() {{ add(resultList1); add(resultList2); }};

        List<List<Object>> result = ListReducer.reduced2TupleListByIndices(fullList, fullIndices);

        assertEquals(expectedResult, result);
    }

    @Test
    public void test2TupleRemoveIndicesInListWhenIndicesOffList() {
        List<Object> list1 = new ArrayList<>() {{ add("a"); add("b"); add("c"); add("d"); add("e"); }};
        List<Object> list2 = new ArrayList<>() {{ add("a"); add("b"); add("c"); }};
        List<List<Object>> fullList = new ArrayList<>() {{ add(list1); add(list2); }};

        List<Integer> indice1 = new ArrayList<>() {{ add(1); add(4); }};
        List<Integer> indice2 = new ArrayList<>() {{ add(2); add(1); }};
        List<List<Integer>> fullIndices = new ArrayList<>() {{ add(indice1); add(indice2); }};

        List<List<Object>> result = ListReducer.reduced2TupleListByIndices(fullList, fullIndices);

        assertEquals(fullList, result);
    }

    @Test
    public void testNTuplesRemoveIndicesInList() {
        List<Object> list1 = new ArrayList<>() {{ add("a"); add("b"); add("c"); add("d"); add("e"); }};
        List<Object> list2 = new ArrayList<>() {{ add("a"); add("b"); add("c"); }};
        List<Object> list3 = new ArrayList<>() {{ add("a"); add("b"); add("c"); }};
        List<Object> list4 = new ArrayList<>() {{ add("a"); add("b"); }};
        List<Object> outerList = new ArrayList<>() {{ add(list1); add(list2); }};
        List<Object> outerList2 = new ArrayList<>() {{ add(outerList); add(list3); }};
        List<Object> fullList = new ArrayList<>() {{ add(outerList2); add(list4); }};

        List<Object> resultList1 = new ArrayList<>() {{ add("b"); add("c"); add("d"); add("e"); }};
        List<Object> resultList2 = new ArrayList<>() {{ add("a");  add("c"); }};
        List<Object> resultList3 = new ArrayList<>() {{ add("b");  add("c"); }};
        List<Object> resultList4 = new ArrayList<>() {{ add("b"); }};
        List<Object> resultOuterList = new ArrayList<>() {{ add(resultList1); add(resultList2); }};
        List<Object> resultOuterList2 = new ArrayList<>() {{ add(resultOuterList); add(resultList3);}};
        List<Object> expectedResult = new ArrayList<>() {{ add(resultOuterList2); add(resultList4); }};


        List<Integer> indice1 = new ArrayList<>() {{ add(0); add(0); add(0); add(0); }};
        List<Integer> indice2 = new ArrayList<>() {{ add(0); add(0); add(1); add(1); }};
        List<Integer> indice3 = new ArrayList<>() {{ add(0); add(1); add(0); }};
        List<Integer> indice4 = new ArrayList<>() {{ add(1); add(0); }};
        List<Integer> indiceIncorrectSize = new ArrayList<>() {{ add(0); }};
        List<Integer> indiceOffList = new ArrayList<>() {{ add(2); add(0); add(0); }};
        List<Integer> indiceOffList2 = new ArrayList<>() {{ add(0); add(1); add(3); }};
        List<Integer> indiceOffList3 = new ArrayList<>() {{ add(-1); add(0); add(0); }};
        List<List<Integer>> fullIndices = new ArrayList<>() {{ add(indice1); add(indice2); add(indice3); add(indice4);
            add(indiceIncorrectSize); add(indiceOffList); add(indiceOffList2); add(indiceOffList3); }};

        List<Object> result = ListReducer.getReducedNTupleListByIndices(fullList, fullIndices);

        assertEquals(expectedResult, result);
    }
}
