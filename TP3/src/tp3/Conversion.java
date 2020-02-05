package tp3;

public class Conversion {

    public double unitConversion(String s) {
        switch (s) {
            case "EUR-USD": return 1.29;
            case "USD-EUR": return 0.91;
            default: return 1.5;
        }
    }
}
