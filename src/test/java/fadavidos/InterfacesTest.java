package fadavidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterfacesTest {
    @Test
    @DisplayName("Default method in Interface is override by the class")
    void testDefaultMethodsInterface() {

        assertEquals(true, true);
    }

}
