package fr.mission.exam;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public final class ListUtils {

    public static <T> List<List<T>> partition(List<T> list, int size) {
        List<List<T>> partitionedList = emptyList();
        if (size <= list.size() && size > 0) {
            partitionedList = getPartition(list, size);
        }
        return partitionedList;
    }

    private static <T> List<List<T>> getPartition(List<T> list, int size) {
        int fromIndex = 0;
        List<List<T>> partitionedList = new ArrayList<>();
        while(fromIndex < list.size()) {
            int toIndex = fromIndex + size;
            if (toIndex > list.size()) {
                toIndex = list.size();
            }
            partitionedList.add(list.subList(fromIndex, toIndex));
            fromIndex += size;
        }
        return partitionedList;
    }
}
