package j8;

import java.util.function.Function;

/**
 * Created by steve on 20/10/15.
 */
public class HigherOrderFunctions2 {

    static class Market {}

    static class MarketBuilder {

        String tag;

        MarketBuilder(String tag) {
            this.tag = tag;
        }

        public Market getMarket(String date) {
            // Get market for tag and date.....
            return new Market();
        }
    }

    public static void main(String[] args) {

        MarketBuilder eodMktBuilder1 = new MarketBuilder("EOD");
        Market m1 = eodMktBuilder1.getMarket("20151020");

        Function<String, Function<String, Market>> mktBuilder2 = tag -> date -> {
            // Get market for tag and date.....
            return new Market();
        };

        Function<String, Market> eodMktBuilder2 = mktBuilder2.apply("EOD");

        Market m2 = eodMktBuilder2.apply("20151020");


    }

}
