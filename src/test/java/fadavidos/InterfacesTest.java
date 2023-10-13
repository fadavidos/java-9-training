package fadavidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterfacesTest {

    interface InterfaceOne {

        /*
         Default methods allow us to add new methods to an interface that are automatically available in the implementations.
         Therefore, we don’t need to modify the implementing classes.
         */
        default String defaultMethod() {
            return "I'm in the InterfaceOne's defaultMethod method";
        }
    }

    interface InterfaceTwo {
        default String defaultMethod() {
            return "I'm in the InterfaceTwo's default method";
        }
    }

    class ClassOne implements InterfaceOne {
        @Override
        public String defaultMethod() {
            return "I'm in the ClassOne's defaultMethod method";
        }
    }

    class ClassTwo implements InterfaceOne {
    }

    class ClassThree implements InterfaceOne, InterfaceTwo {

        /*
        Both Interfaces have the same 'defaultMethod' method. I have to override the method and decide what parent class
        will be call
         */
        @Override
        public String defaultMethod() {
            return InterfaceTwo.super.defaultMethod();
        }
    }

    @Test
    @DisplayName("Default method in Interface is override by the class")
    void testDefaultMethodsInterface() {
        ClassOne classOne = new ClassOne();
        assertEquals("I'm in the ClassOne's defaultMethod method", classOne.defaultMethod());
    }

    @Test
    @DisplayName("Default method in Interface is not override by the class when it does not implement the default method")
    void testDefaultMethodInterface() {
        ClassTwo classTwo = new ClassTwo();
        assertEquals("I'm in the InterfaceOne's defaultMethod method", classTwo.defaultMethod());
    }

    @Test
    @DisplayName("Default method in Interface is not override by the class")
    void testDefaultMethodInterfaceThree() {
        ClassThree classThree = new ClassThree();
        assertEquals("I'm in the InterfaceTwo's default method", classThree.defaultMethod());
    }

}
