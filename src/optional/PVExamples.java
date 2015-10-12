package optional;

import domain.PV;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Created by steve on 5/10/15.
 */
public class PVExamples {

    public static void main(String[] args) {

        // Returning an Optional

        PV withError = new PV("GBP", "1", "some error", 1.0);

        System.out.println("with error is: " + withError.getError());

        PV withoutError = new PV("GBP", "1", 1.0);

        System.out.println("without error is: " + withoutError.getError());

        // Summing values

        List<PV> pvs = Arrays.asList(withError, withoutError);

        DoubleStream valued = pvs.stream()
                .filter(p -> p.getError().isPresent())
                .mapToDouble(p -> p.getValue());

//        DoubleStream valued = pvs.stream()
//                .filter(pv -> pv.getError().isPresent())
//                        .mapToDouble(PV::getValue);

        double total = valued.sum();

        System.out.println("Total PV is: " + total);

        // Getting all errors - as string

        String errorMsg = pvs.stream()
            .map(PV::getError)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .reduce("", (acc, err) -> acc + " " + err);   // show different signature (keyboard shortcut?)
        System.out.println("PV Errors: " + errorMsg);

        // Getting all errors - as map

        Map<String, String> errors = pvs.stream()
                .filter(p -> p.getError().isPresent())
                .collect(Collectors.toMap(PV::getTradeId, p -> p.getError().get()));

        System.out.println(errors);
    }
}
