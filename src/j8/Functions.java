package j8;

public class Functions {

    @FunctionalInterface
    interface TriFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
    }


    public static double combine(TriFunction<Integer,
            Double, Boolean, Double> fn) {
        int i = 1;
        double d = 1.0;
        boolean b = true;
        return fn.apply(i, d, b);
    }

    public static void main(String[] args) {

        TriFunction<Integer, Double, Boolean, Double> add3 =
                (i, d, b) -> i + d + (b ? 1 : 0);
        double r1 = combine(add3);
        System.out.println(r1);

        double r2 = combine((i, d, b) -> d);
        System.out.println(r2);
    }
}
