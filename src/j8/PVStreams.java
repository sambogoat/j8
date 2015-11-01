package j8;

import java.util.*;

import static java.util.stream.Collectors.*;

public class PVStreams {

    public static void main(String[] args) {

        List<PV> pvs = Arrays.asList(
                new PV("1", "GBP", "some error", Double.NaN),
                new PV("2", "GBP", 1.0),
                new PV("3", "USD", 1.0));

        //Stream<PV> pvs = Stream.of(..., ...);

        // 1) Summing values with for loop
        double sum = 0.0;
        for (PV pv: pvs) {
            if (pv.getError2() == null) {
                sum = sum + pv.getValue();
            }
        }
        System.out.println("For loop sum:: " + sum);

        // 2) Summing values with Streams
        double sum2 = pvs.stream()
                .filter(p -> !p.getError().isPresent())
                .mapToDouble(PV::getValue)
                .sum();
        System.out.println("Streams sum: " + sum2);

        // 3) Grouped aggregation
        Map<String, Double> groupedSum = pvs.stream()
                .filter(p -> !p.getError().isPresent())
                .collect(groupingBy(PV::getCcy, summingDouble(PV::getValue)));
        System.out.println("Grouped sum: " + groupedSum);

        // 4) Getting all errors - as map tradeId -> error
        Map<String, String> errors = pvs.stream()
                .filter(p -> p.getError().isPresent())
                .collect(toMap(PV::getTradeId, p -> p.getError().get()));
        System.out.println("Errors map " + errors);

        // 5) Getting all errors - as concatenated string (reduce)
        String errorMsg = pvs.stream()
                .map(PV::getError)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .reduce("errors:", (acc, err) -> acc + " " + err);
        System.out.println(errorMsg);


        // 6) Getting all errors - as concatenated string (collector)
        String errorMsg2 = pvs.stream()
                .map(PV::getError2)
                .filter(Objects::nonNull)
                .collect(joining(",", "errors: ", ""));
        System.out.println(errorMsg2);
    }
}
