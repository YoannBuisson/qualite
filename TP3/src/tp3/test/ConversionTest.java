package tp3.test;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import tp3.Conversion;
import tp3.Money;
import tp3.exception.NullCurrencyException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ConversionTest {

    @Mock
    private Conversion conversionMock;

    @InjectMocks
    private Money money = new Money(45, "EUR");

    ConversionTest() throws Exception {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(conversionMock.unitConversion("EUR-USD")).thenReturn(1.29);
        when(conversionMock.unitConversion("USD-EUR")).thenReturn(0.91);
        when(conversionMock.unitConversion(startsWith(" "))).thenThrow(IllegalArgumentException.class);
    }
}