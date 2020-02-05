package tp3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp3.Money;
import tp3.exception.NullCurrencyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    private Money money;

    @BeforeEach
    void init() throws Exception {
        money = new Money(45, "EUR");
    }

    @Test
    void shouldThrowExceptionForNegativeAmount() throws Exception {
        Money mAmount = new Money(-4, "EUR");
        assertEquals(4, mAmount.amount());
    }

    @Test
    void shouldThrowExceptionForNullCurrency() {
        assertThrows(NullCurrencyException.class, () -> new Money(45, null));
    }

    @Test
    void shouldReturnTheRightAmountOfMoney() {
        assertEquals(45, money.amount());
    }

    @Test
    void shouldReturnTheRightCurrencyName() {
        assertEquals("EUR", money.currency());
    }

    @Test
    void shouldAddTheAmountCorrectlyForSameCurrency() throws Exception {
        money.add(new Money(23, "EUR"));
        assertEquals(68, money.amount());
    }

    @Test
    void shouldAddTheAmountCorrectlyForDifferentCurrency() throws Exception {
        money.add(new Money(23, "USD"));
        assertEquals((int) (45 + (23 * 1.29)), money.amount());
    }

    @Test
    void shouldAddTheAmountCorrectlyForValidCurrency() throws NullCurrencyException {
        money.add(23, "USD");
        assertEquals((int) (45 + (23 * 0.91)), money.amount());
    }

    @Test
    void shouldNotAddAmountAndThrowExceptionForNullCurrency() {
        assertThrows(NullCurrencyException.class, () -> money.add(23, null));
    }

    @Test
    void shouldAddAmountForNegativeAmount() throws NullCurrencyException {
        money.add(-23, "USD");
        assertEquals((int) (45 + (23 * 0.91)), money.amount());
    }

    @Test
    void shouldAddAmountForSameCurrency() throws NullCurrencyException {
        money.add(23, "EUR");
        assertEquals(45 + 23, money.amount());
    }

    @Test
    void shouldSubMoneyCorrectlyWithDifferentCurrency() throws Exception {
        Money mAmount = new Money(4, "USD");
        money.sub(mAmount);
        assertEquals((int) (45 - (4 * 0.91)), money.amount());
    }

    @Test
    void shouldSubMoneyCorrectlyWithSameCurrency() throws Exception {
        Money mAmount = new Money(4, "EUR");
        money.sub(mAmount);
        assertEquals(45 - 4, money.amount());
    }

    @Test
    void shouldSubMoneyCorrectlyWithNegativeMoney() throws Exception {
        Money mAmount = new Money(-4, "EUR");
        money.sub(mAmount);
        assertEquals(45 - 4, money.amount());
    }

    @Test
    void shouldConvertWithDefaultConversion() throws NullCurrencyException {
        money.add(23, "GBP");
        assertEquals((int)(45 + (23 * 1.5)), money.amount());
    }
}