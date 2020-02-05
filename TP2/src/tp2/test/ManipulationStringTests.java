package tp2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tp2.ManipulationString;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ManipulationStringTests {

    @Mock
    private ManipulationString msMock;

    @BeforeEach
    void setUp() {
        msMock = new ManipulationString();
    }

    @Test
    void shouldFail() {
//        int expected = 100;
//        assertEquals (expected , ms.sum("d"));
//        expected = 265;
//        assertEquals (expected , ms.sum("Add"));
//        expected = 0;
//        assertEquals (expected , ms. sum(""));
        when(msMock.sum("sdsfd")).thenReturn(50);
        assertEquals(50, msMock.sum("sdsfd"));
    }

    @Test
    void shouldFailBecauseOfNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> msMock.sum(null));

    }
}
