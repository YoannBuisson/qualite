package tp2.test;

import org.junit.jupiter.api.Test;
import tp2.HelloWorld;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldFailTests {

    @Test
    void shouldFail() {
        HelloWorld hw = new HelloWorld();
        assertEquals(hw.printHelloWorld(), "Hello World!");
    }
}
