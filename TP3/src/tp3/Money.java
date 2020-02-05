package tp3;

import tp3.exception.NullCurrencyException;

public class Money {

    private int amount;
    private String curr;
    private Conversion conversion;

    public Money(int amount, String currency) throws Exception {
        if (amount <= 0) {
            this.amount = Math.abs(amount);
        } else {
            this.amount = amount;
        }
        if(currency == null) {
            throw new NullCurrencyException("Null currency");
        } else {
            this.curr = currency;
        }
        conversion = new Conversion();
    }
    /***
     *
     * @return
     */
    public int amount() {
        return this.amount;
    }

    /***
     *
     * @return
     */
    public String currency() {
        return curr;
//        switch (curr) {
//            case "EUR": return "Euros";
//            case "GBP": return "Livre Sterling";
//            case "CHF": return "Franc Suisse";
//            case "USD": return "Dollars";
//            default: return "currency";
//        }
    }

    public void add(Money m) {
        if(m.amount() != 0) {
            if (m.currency().equals(currency())) {
                this.amount += m.amount();
            } else {
                this.amount += m.amount * conversion.unitConversion(curr + String.format("-%s", m.currency()));
            }
        }
    }

    public void add(int nAmount, String nCurrency) throws NullCurrencyException {
        if(nCurrency == null) {
            throw new NullCurrencyException("Null currency");
        }
        if(nAmount <= 0) {
            nAmount = Math.abs(nAmount);
        }

        if (nCurrency.equals(curr)) {
            this.amount += nAmount;
        } else {
            this.amount += nAmount * conversion.unitConversion(String.format("%s-", nCurrency) + curr);
        }
    }

    public void sub(Money m) {
        if(m.amount() != 0) {
            if (m.currency().equals(currency())) {
                this.amount -= m.amount();
            } else {
                this.amount -= m.amount * conversion.unitConversion(String.format("%s-", m.currency()) + curr);
            }
        }
    }
}
