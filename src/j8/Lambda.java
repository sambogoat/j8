package j8;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lambda {

    public static void main(String[] args) {

        Stream<PV> pvs = Stream.of(
                new PV("1", "GBP", "some error", Double.NaN),
                new PV("2", "GBP", 1.0),
                new PV("3", "USD", 1.0));


        String ccy = "GBP";

        // Lambda can refer to names in the lexical context (compare to inner classes).

        // Syntax
        // 1. Can omit the data type of the parameters in a lambda expression.
        // 2. Can omit the parentheses if there is only one parameter.
        // 3. Can omit body braces for single expressions.

        Predicate<PV> p = pv -> pv.getCcy().equals(ccy);

//        BiFunction<String, String, Integer> bif = (s1, s2) -> {
//            System.out.println(s1);
//            return (s1+s2).length();
//        };

        pvs.filter(p);

        // First - desugar the lambda to a static method

        //private static boolean lambda$main$0(String capturedK, PV pv) {
        //    return pv.getCcy().equals(capturedK);
        //}

        // Static compiler emits the invoke dynamic instruction

        //Predicate $p = indy(bootstrap=LambdaMetafactory, staticArgs=[Predicate, lambda$1], dynArgs=[ccy]))

        // pvs.removeAll($p)

    }
}
