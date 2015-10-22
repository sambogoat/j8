package j8;

import java.time.LocalDate;
import java.util.function.Function;

public class HigherOrderFunctions1 {

    public static void main(String[] args) {

        Function<Integer, Function<LocalDate, LocalDate>> rollDate = days -> dt -> dt.plusDays(days);

        Function<LocalDate, LocalDate> roll1 = rollDate.apply(1);

        Function<LocalDate, LocalDate> roll3 = rollDate.apply(3);

        System.out.println(roll1.apply(LocalDate.now()));

        System.out.println(roll3.apply(LocalDate.now()));

    }

}

