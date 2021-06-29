package problem2;

import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ListReducer {

    public static List<Object> reducedListByIndices(List<Object> list, List<Integer> indices) {
        if (!isEmpty(list) && !isEmpty(indices)) {
            Collections.reverse(indices);
            indices.stream()
                    .filter(ind -> ind >= 0 && ind < list.size())
                    .forEach(i -> {
                        list.remove(i.intValue());
                    });
        }
        return list;
    }

    public static List<List<Object>> reduced2TupleListByIndices(List<List<Object>> list,
                                                                List<List<Integer>> indices) {
        if (!isEmpty(list) && !isEmpty(indices)) {
            Collections.reverse(indices);
            indices.stream()
                    .filter(i -> i.size() == 2 && i.get(0) < list.size())
                    .forEach(ind -> {
                        List<Object> innerList = list.get(ind.get(0));
                        if (!isEmpty(innerList)) {
                            reducedListByIndices(innerList, Collections.singletonList(ind.get(1)));
                        }
                    });
        }
        return list;
    }

    public static List<Object> getReducedNTupleListByIndices(List<Object> list,
                                                             List<List<Integer>> indices
    ) {
        if (!isEmpty(list)) {
            Collections.reverse(indices);
            indices.stream()
                    .filter(ind -> ind.size() > 1)
                    .forEach(ind -> iterateNTuples(list, ind, 0));
        }
        return list;
    }

    private static void iterateNTuples(List<Object> list, List<Integer> ind, int iteration) {
        if (!isEmpty(list) && !isEmpty(ind)) {
            if (iteration + 1 == ind.size()) {
                reducedListByIndices(list, Collections.singletonList(ind.get(ind.size() - 1)));
            } else if (ind.get(iteration) >= 0 && ind.get(iteration) < list.size()) {
                List<Object> innerList = (List<Object>) list.get(ind.get(iteration));
                iterateNTuples(innerList, ind, iteration + 1);
            }
        }
    }
}
