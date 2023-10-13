package fadavidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FunctionalInterfacesTest {

    // Any interface with a single abstract method
    // Functional interface is pure functional, stateless classes

    @FunctionalInterface
    interface InterfaceOne<T> {
        String toString(T number);
    }

    @Test
    void test1() {

        InterfaceOne<Integer> integerInterfaceOne = new InterfaceOne<Integer>(){
            @Override
            public String toString(Integer number) {
                return String.valueOf(number);
            }
        };

        InterfaceOne<Double> doubleInterfaceOne = new InterfaceOne<Double>() {
            @Override
            public String toString(Double number) {
                return String.valueOf(number);
            }
        };

        assertEquals("10", integerInterfaceOne.toString(10));
        assertEquals("10.2", doubleInterfaceOne.toString(10.2));
    }


}
