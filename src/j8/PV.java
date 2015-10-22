package j8;

import java.util.Optional;

public class PV {

    private String ccy;
    private String tradeId;
    private String error;
    private double value;

    public PV(String tradeId, String ccy, String error, double value) {
        this.tradeId = tradeId;
        this.ccy = ccy;
        this.error = error;
        this.value = value;
    }

    public PV(String tradeId, String ccy, double value) {
        this.tradeId = tradeId;
        this.ccy = ccy;
        this.value = value;
    }

    public Optional<String> getError() {
        return Optional.ofNullable(error);
    }

    public String getError2() {
        return error;
    }

    public double getValue() {
        return value;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getCcy() { return ccy; }

    public static void main(String[] args) {

        PV withError = new PV( "1", "GBP", "some error", 1.0);

        PV withoutError = new PV("1", "GBP", 1.0);

        System.out.println("with error: " + withError.getError());
        // -> "with error: Optional[some error]"

        System.out.println("without error is: " + withoutError.getError());
        // -> "without error: Optional.empty"
    }
}
