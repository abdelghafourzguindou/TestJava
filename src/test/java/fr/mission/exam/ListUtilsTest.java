package fr.mission.exam;

import org.junit.Test;
import java.util.Collections;
import java.util.List;
import static fr.mission.exam.ListUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ListUtilsTest {

    private static final List<Integer> LIST = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    private static final Integer SIZE_EQUAL_ZERO = 0;
    private static final Integer NO_MATCH_MODULO_SIZE_GREAT_THAN_ZERO = 5;
    private static final Integer MATCH_MODULO_SIZE_GREAT_THAN_ZERO = 4;
    private static final Integer SIZE_GREAT_THAN_LIST_LENGTH = 1000;

    @Test
    public void partition_should_return_emptyList_when_list_is_empty() {
        assertThat(partition(Collections.emptyList(), MATCH_MODULO_SIZE_GREAT_THAN_ZERO)).isEmpty();
    }

    @Test
    public void partition_should_return_emptyList_when_size_equal_to_0() {
        List<List<Integer>> list = partition(LIST, SIZE_EQUAL_ZERO);
        assertThat(list).isEmpty();
    }

    @Test
    public void partition_should_return_emptyList_when_size_is_great_than_list_length() {
        assertThat(partition(LIST, SIZE_GREAT_THAN_LIST_LENGTH)).isEmpty();
    }

    @Test
    public void partition_should_return_list_of_subList_when_list_length_modulo_size_equal_to_0() {
        List<List<Integer>> list = partition(LIST, MATCH_MODULO_SIZE_GREAT_THAN_ZERO);
        List<List<Integer>> expectedList = List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8));
        assertThat(list).isNotEmpty();
        assertThat(list).isEqualTo(expectedList);
    }

    @Test
    public void partition_should_return_list_of_subList_when_list_length_modulo_size_different_to_0() {
        List<List<Integer>> list = partition(LIST, NO_MATCH_MODULO_SIZE_GREAT_THAN_ZERO);
        List<List<Integer>> expectedList = List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8));
        assertThat(list).isNotEmpty();
        assertThat(list).isEqualTo(expectedList);
    }
}