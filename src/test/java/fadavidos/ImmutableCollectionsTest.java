package fadavidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ImmutableCollectionsTest {

    @Test
    void immutableListElementCannotBeRemoved(){
        List<String> myList = List.of("one");
        assertThrows(
            UnsupportedOperationException.class,
            () -> myList.remove(0)
        );
    }

    @Test
    void immutableListElementCannotBeAdded(){
        List<String> myList = List.of("one");
        assertThrows(
                UnsupportedOperationException.class,
                () -> myList.add("two")
        );
    }

    @Test
    void immutableListElementCannotBeNull(){
        assertThrows(
                NullPointerException.class,
                () -> List.of("one", null)
        );
    }

    @Test
    void immutableListSameOrder(){
        // The order of elements in the list is the same as the order of the provided arguments, or of the elements in the provided array.
        List<String> myList = List.of("one", "two", "three", "four");
        assertEquals("one", myList.get(0));
        assertEquals("two", myList.get(1));
        assertEquals("three", myList.get(2));
        assertEquals("four", myList.get(3));
    }
    
    @Test
    void immutableSetDoNotAllowDuplicates(){
        assertThrows(
                IllegalArgumentException.class,
                () -> Set.of("one", "one")
        );
    }

    @Test
    void immutableSetElementsCannotBeAdded(){
        Set<String> mySet = Set.of("one");
        assertThrows(
                UnsupportedOperationException.class,
                () -> mySet.add("two")
        );
    }
    
    @Test
    void immutableMapElementsCannotBeAdded() {
        Map<String, Integer> myMap = Map.ofEntries(
                Map.entry("one", 1),
                Map.entry("two", 2)
        );
        assertThrows(
                UnsupportedOperationException.class,
                () -> myMap.put("three", 3)
        );
    }

    @Test
    void immutableCollectionUsingStreams(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ToIntFunction<Integer> duplicate = number -> number * 2;
        int total = numbers.stream()
                .mapToInt(duplicate)
                .sum();
        assertEquals(110, total);
        // the original collection shouldn't be updated
        assertEquals(1, numbers.get(0));
        assertEquals(6, numbers.get(5));
    }
}

