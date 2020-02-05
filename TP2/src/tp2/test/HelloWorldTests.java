package tp2.test;

import org.junit.jupiter.api.Test;
import tp2.HelloWorld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloWorldTests {

    @Test
    void shouldWork() {
        HelloWorld hw = new HelloWorld();
        assertNotNull(hw.printHelloWorld());
        assertEquals(hw.printHelloWorld(), "Hello World!");
    }
}
