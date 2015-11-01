package j8;

import java.util.function.Function;

public class HigherOrderFunctions2 {

    // A domain object
    static class Market {}

    // A service object
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

    // A service function
    static Function<String, Function<String, Market>> mktBuilder2 =
            tag -> data -> {
                // Get market for tag and date...
                return new Market();
            };

    public static void main(String[] args) {

        MarketBuilder eodMktBuilderOO = new MarketBuilder("EOD");
        Market m1 = eodMktBuilderOO.getMarket("20151020");

        Function<String, Market> eodMktBuilderFP = mktBuilder2.apply("EOD");
        Market m2 = eodMktBuilderFP.apply("20151020");


    }

}
