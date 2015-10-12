package domain;

import java.util.Optional;

/**
 * Created by steve on 5/10/15.
 */
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

    public double getValue() {
        return value;
    }

    public String getTradeId() {
        return tradeId;
    }
}
