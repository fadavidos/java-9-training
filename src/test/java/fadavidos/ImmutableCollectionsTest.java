package fadavidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Set;

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
}

