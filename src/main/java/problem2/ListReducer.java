package problem2;

import org.apache.commons.lang3.ArrayUtils;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ListReducer {

    public static List<String> getReducedListByIndices(List<String> stringList, int[] indices) {
        if (!isEmpty(stringList)) {
            ArrayUtils.reverse(indices);
            for (int ind : indices) {
                if (ind >= 0 && ind < stringList.size()) {
                    stringList.remove(ind);
                }
            }
        }
        return stringList;
    }
}
